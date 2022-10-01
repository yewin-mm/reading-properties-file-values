# reading-properties-file-values
<!-- PROJECT SHIELDS -->

<!--
*** I'm using markdown "reference style" links for readability.
*** Reference links are enclosed in brackets [ ] instead of parentheses ( ).
*** See the bottom of this document for the declaration of the reference variables
*** for contributors-url, forks-url, etc. This is an optional, concise syntax you may use.
*** https://www.markdownguide.org/basic-syntax/#reference-style-links
-->
[![Contributors][contributors-shield]][contributors-url]
[![Forks][forks-shield]][forks-url]
[![Stargazers][stars-shield]][stars-url]
[![Issues][issues-shield]][issues-url]
[![LinkedIn][linkedin-shield]][linkedin-url]

<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->
[contributors-shield]: https://img.shields.io/github/contributors/yewin-mm/reading-properties-file-values.svg?style=for-the-badge
[contributors-url]: https://github.com/yewin-mm/reading-properties-file-values/graphs/contributors
[forks-shield]: https://img.shields.io/github/forks/yewin-mm/reading-properties-file-values.svg?style=for-the-badge
[forks-url]: https://github.com/yewin-mm/reading-properties-file-values/network/members
[stars-shield]: https://img.shields.io/github/stars/yewin-mm/reading-properties-file-values.svg?style=for-the-badge
[stars-url]: https://github.com/yewin-mm/reading-properties-file-values/stargazers
[issues-shield]: https://img.shields.io/github/issues/yewin-mm/reading-properties-file-values.svg?style=for-the-badge
[issues-url]: https://github.com/yewin-mm/reading-properties-file-values/issues
[linkedin-shield]: https://img.shields.io/badge/-LinkedIn-black.svg?style=for-the-badge&logo=linkedin&colorB=555
[linkedin-url]: https://www.linkedin.com/in/ye-win-1a33a292/
[product-screenshot]: images/screenshot.png


<h1 align="center">
  Overview
  <img src="https://github.com/yewin-mm/reading-properties-file-values/blob/master/github/template/images/overview/Reading_Properties_File_Values.png" /><br/>
</h1>

# reading-properties-file-values
* This is the sample project for Reading values from properties file.

<!-- TABLE OF CONTENTS -->
## Table of Contents
- [About The Project](#about-the-project)
    - [Built With](#built-with)
- [Getting Started](#getting-started)
    - [Before you begin](#before-you-begin)
    - [Clone Project](#clone-project)
    - [Prerequisites](#prerequisites)
    - [Instruction](#instruction)
- [Contact Me](#contact)
- [Contributing](#Contributing)


<a name="about-the-project"></a>
## ⚡️About The Project
This is the sample reading properties file values project for Reading config data from properties file.
You can learn how to Read values from properties file by 3 ways (most popular ways).
1. Read by using @Value.
2. Read by using Configuration Properties.
3. Read by using Environment.
* You can use one of the above ways in your application as you want and depend on your application.
* Config values from properties file is use for doing logic to avoid hard coded adding value in class level. 
Because if you write code with hard coded for some values, it's hard to change when it's need to change as business requirement.
* So, if you go with that way in your application, you can easily change in properties file `without touching classes` when it's need to change.
* You can also change properties file values without restarting the application.
* So, getting some values (it might change as dynamic, eg. api url) from properties file is the good approach in java projects.
* You can do whatever you want with that values. As an example, 
  * calling other api (url can get from properties file), getting creadentials (client id, secret, username, password) to call api, etc.
  * adding prefix, checking prefix, checking id, etc.
  * getting columns name to export excel, csv, etc.
  * getting your server ip to do other operations (eg. connect to store information in dashboard server), etc.
  * getting file server ip and url path (to upload file in file server), etc.
  * getting static email list to send (if it's increase day by day, it's better save in db), getting sender email and password, etc.
  * doing other logic or etc. whatever you want.

<a name="built-with"></a>
### 🪓 Built With
This project is built with
* [Java](https://www.oracle.com/au/java/technologies/javase/javase-jdk8-downloads.html)
* [Maven](https://maven.apache.org/download.cgi)


<a name="getting-started"></a>
## 🔥 Getting Started
This project is built with java, maven and use `Project Lombok` as plugin.
So, please make sure all are installed in you machine.


<a name="before-you-begin"></a>
### 🔔 Before you begin
If you are new in Git, Github and new in Spring Boot configuration structure, <br>
You should see basic detail instructions first in here [Spring Boot Application Instruction](https://github.com/yewin-mm/spring-boot-app-instruction)<br>
If you are not good enough in basic API knowledge with Java Spring Boot, you should learn below example projects first. <br>
Click below links.
* [Spring Boot Sample CRUD Application](https://github.com/yewin-mm/spring-boot-sample-crud)


<a name="clone-project"></a>
### 🥡 Clone Project
* Clone the repo
   ```sh
   git clone https://github.com/yewin-mm/reading-properties-file-values.git


<a name="prerequisites"></a>
### 🔑 Prerequisites
Prerequisites can be found in here [Spring Boot Application Instruction](https://github.com/yewin-mm/spring-boot-app-instruction).


<a name="instruction"></a>
### 📝 Instruction
* Check the config values in `application.properties` file and `config.properties` file.
* There I added some demo config data.
* Run the project in your IDE.

* Import `read-properties-file-value.postman_collection.json` file under project directory (see that file in project directory) into your installed Postman application.
    * Click in your Postman (top left corner) import -> file -> upload files -> {choose that json file} and open/import.
    * After that, you can see the folder which you import from file in your Postman.
* Now, you can 'Test' this project by calling API from Postman.
    * Open your imported folder in postman and inside this folder, you will see total of 4 API requests and you can test it all by clicking `Send` button and see the response.
    * See the response and that responses should be same with `application.properties` file values and `config.properties` file values
    * You can also check in your IDE log for some print out values.

* After that you can see the code and check the code which you don't know. You can learn it and you can apply in your job or study fields.

***Have Fun and Enjoy in Learning Code***


<a name="contact"></a>
## ✉️ Contact
Name - Ye Win <br> LinkedIn profile -  [Ye Win's LinkedIn](https://www.linkedin.com/in/ye-win-1a33a292/)  <br> Email Address - yewin.mmr@gmail.com

Project Link: [Reading Properties File Values](https://github.com/yewin-mm/reading-properties-file-values)


<a name="contributing"></a>
## ⭐ Contributing
Contributions are what make the open source community such an amazing place to be learn, inspire, and create. Any contributions you make are **greatly appreciated**.
<br>If you want to contribute....
1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/yourname`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push -u origin feature/yourname`)
5. Open a Pull Request

