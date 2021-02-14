<h1>Vaccathon</h1>


<h2> Architiecture </h2>

![plot](images/BS-Page.png)

<h2> How to run the project </h2>
<p>

  1. Clone the repo locally `git clone https://github.com/devopsusr-tech/hackerearth2021.git`
  2. Go to root of the project
  3. Run `docker-composer up`
  4. It will be run on http://localhost

</p>

<h2> Requirements to develop </h2>
<p>

  - Docker
  - Java 11
  - Apache Maven
  - npm
  - Node JS
  -
</p>

<h2> How to setup Backend </h2>
1. ...

<h2> How to setup Frontend </h2>
<a href="frontend/vaccathon/README.md">
  Guidelines for setuo the frontend
</a>

<h2> Continuous Integration </h2>
  This project is supplied by a Continuous Integration (CI) pipeline. Whenever a push / merged pull request occurs in the main branch, a Jenkins CI pipeline is triggered.
</a>
<br>
<img src="images/jenkins.png" width="600" height="400">

<p>
The <a href="http://3.120.176.45:8080/">Jenkins pipeline</a> will be able to push the latest changes in the running production envrionment. Before deploying the changes the newest code should pass the quality gates such as static code quality, unit tests and builds. If the new code passes these blocks, with the manual approve of the user, the newest code will be packaged in docker containers and deployed to the runinng environment.

</p>

<h2> License </h2>
<a href="https://opensource.org/licenses/MIT">
  <img alt="GitHub" src="https://img.shields.io/github/license/devopsusr-tech/hackerearth2021">
</a>
