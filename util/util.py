import re
import os

def file2str(filename):
    res = ""
    with open(filename, "r") as f:
        for line in f.readlines():
            res += line
    return res

def parse_code_from_reply(content):
    """
    Extracts code contained within triple backticks from the provided content.
    If a language identifier (like 'java') is present, it is removed.
    If no code block is found, the original content is returned.
    """
    # Regex to match code blocks wrapped in triple backticks,
    # optionally with a language identifier (e.g., 'java').
    match = re.search(r"```(?:\s*java\s*)?\n?(.*?)\n?```", content, re.DOTALL)
    if match:
        return match.group(1).strip()
    return content
