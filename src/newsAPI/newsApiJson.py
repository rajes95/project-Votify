import requests
import json
from datetime import datetime
from datetime import timedelta
"""
@author: Rajesh Sakhamuru
@version: 3/18/2020

Prints the JSON data of the top 20 news articles from the last 2 days
relating to the "Democratic Presidential Primary 2020" keyword.

"""

tod = datetime.today()
d = timedelta(days=2)
a = (tod - d)
twoDaysAgo = a.strftime('%Y-%m-%d')

url = ('http://newsapi.org/v2/everything?'
       'q=Democratic Presidential Primary 2020&'  # keyword
       'from=' + twoDaysAgo + '&'
       'sortBy=popularity&'  # 'popularity' or 'relevancy'
       'apiKey=9a1b6ef13dee41a58ec7ef35b52829ba')

response = requests.get(url)

data = response.json()

newStr = json.dumps(data, indent=2)

print(newStr)

# for article in data['articles']:
#     print(article['source']['name'], ":", article['title'])
