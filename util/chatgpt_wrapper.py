import openai
import os
import time
import threading

def create_chatgpt_config(messages):
    config = {
        "model": "o1",
        "messages": []
    }
    config["messages"] = messages
    return config

def timeout_handler():
    raise Exception("end of time")

def request_chatgpt_engine(config):
    ret = None
    while ret is None:
        try:
            timer = threading.Timer(100, timeout_handler)  # Set a timeout of 100 seconds
            timer.start()
            ret = openai.ChatCompletion.create(**config)
            timer.cancel()  # Cancel the timeout if the request is successful
        except openai.error.InvalidRequestError as e:
            print(f"Invalid Request: {e}")
            timer.cancel()
        except openai.error.RateLimitError as e:
            print("Rate limit exceeded. Waiting...")
            print(e)
            timer.cancel()
            time.sleep(60)  # Wait for a minute before retrying
        except openai.error.APIConnectionError as e:
            print("API connection error. Waiting...")
            timer.cancel()
            time.sleep(60)  # Wait for a minute before retrying
        except Exception as e:
            print(f"Unknown error: {e}")
            timer.cancel()
            time.sleep(1)  # Wait for a second before retrying
    return ret
