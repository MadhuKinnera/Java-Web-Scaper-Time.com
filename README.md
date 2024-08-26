# Java Web Scraping and REST API Project

**Author:** Madhu Kinnera

## Overview

This project is a simple Java application that performs web scraping on [TIME.com]([https://time.com](https://time.com/search/?q=stories)) to fetch the top 6 stories and exposes the scraped data as a REST API. The application is built entirely in plain Java using the `java.net` and `java.io` packages, without any external frameworks. The web server runs on port **8000** and serves the scraped content in JSON format.

## Features

- **Web Scraping**: Extracts the top 6 stories from TIME.com using Java's `java.net` package.
- **REST API**: Exposes the scraped data as a REST API that can be accessed via `localhost:8000`.
- **JSON Response**: Returns the scraped data in a structured JSON format.
- **Simple HTTP Server**: Implements a basic HTTP server using `ServerSocket` and `Socket` from the `java.net` package.

## Project Structure

- **dtlassignment/com/dtl/ResponseServer**: The main entry point for the application, responsible for starting the HTTP server and handling HTTP requests.
- **dtlassignment/com/dtl/JSONResponse**: Contains logic for web scraping using Java's `java.net` package and string manipulation to parse HTML content.

## Getting Started

### Prerequisites

- **Java Development Kit (JDK) 8 or higher**: Ensure you have the JDK installed on your machine. You can check your Java version by running `java -version` in your terminal or command prompt.

### How to Run

1. **Clone the Repository**
   ```bash
   javac -d . com/dtl/ResponseServer.java com/dtl/JSONResponse.java
   
2. **Compile the Java Files**
   ```bash
   git clone https://github.com/MadhuKinnera/Java-Web-Scaper-Time.com.git
   cd Java-Web-Scaper-Time.com/dtlassignment

3. **Run the Application**
   ```bash
   java com.dtl.ResponseServer

4. **Run the Application**
   ```bash
    java com.dtl.ResponseServer and Access Response From  http://localhost:8000

### Sample Json Response Top 6 Stories

```bash
[
  {
    "title": "Tell Queer Stories Instead of Focusing on Queer Characters | TIME",
    "link": "https://time.com/6155025/queer-characters-tv-euphoria-yellowjackets/"
  },
  {
    "title": "Oh, The (War) Stories You'll Hear | TIME.com",
    "link": "https://nation.time.com/2011/11/10/oh-the-war-stories-you%E2%80%99ll-hear/"
  },
  {
    "title": "Michael Twitty: The Stories Food Can Tell | TIME",
    "link": "https://time.com/6551567/michael-twitty-food-essay/"
  },
  {
    "title": "Journalists Reflect on Covering Stories About Their Communities ...",
    "link": "https://time.com/6046303/journalists-reflect-on-covering-their-communities/"
  },
  {
    "title": "One Million Truths Shares Black Americans' Stories of Racism | TIME",
    "link": "https://time.com/5958495/one-million-truths-mark-eckhardt/"
  },
  {
    "title": "Leaving Home: All War Stories Begin Like This… | TIME.com",
    "link": "https://nation.time.com/2012/09/07/leaving-home-all-war-stories-begin-like-this/"
  }
]

