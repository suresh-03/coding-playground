from flask import Flask, render_template, url_for, request, redirect, session
import pickle
import os
import re
from newsapi import NewsApiClient


app = Flask(__name__,template_folder='../template')

model=pickle.load(open('goldnewsanalysis.pkl','rb'))

@app.route('/',methods=['POST','GET'])
def homepage():
    return render_template('home.html')


@app.route('/prediction', methods=['POST', 'GET'])

def predictionpage():

    if request.method == 'POST':
        newsline = request.form["newheadline"]
        pred=[newsline]
        output=model.predict(pred)
        print(output)
        if output==['positive']:
            return render_template('index.html',input=newsline, output='upward movement in gold price') 
        if output==['negative']:
            return render_template('index.html',input=newsline, output='downward movement in gold price')
        if output==['neutral']:
            return render_template('index.html',input=newsline, output='steady movement in gold price') 
        if output==['none']:
            return render_template('index.html',input=newsline, output='this news headline is not related to gold news') 
    return render_template('index.html')


if __name__ == '__main__':
    app.run(debug=True)