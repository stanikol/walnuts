Walnuts shop with Play 2.5 Silhouette 4.0 Slick PostgreSQL 
===========================================================

This project is based on [Play Silhouette seed](https://www.lightbend.com/activator/template/play-silhouette-4.0-slick-postgres-seed).

## Features

* Sign Up
* Sign In (Credentials)
* Dependency Injection with Guice
* Publishing Events
* Avatar service
* Social Auth (Facebook, Google+, VK, Twitter, Xing, Yahoo)
* Two-factor authentication with Clef
* Remember me functionality
* Password reset/change functionality
* Account activation functionality
* Email sending and auth token cleanup
* [Security headers](https://www.playframework.com/documentation/2.5.x/SecurityHeaders)
* [CSRF Protection](https://www.playframework.com/documentation/2.5.x/ScalaCsrf)

## Planned Features

## Getting Started

* Install from activator template or clone this repository
* Modify `database.conf` and fill in your database connection data
* Modify `mailer.conf` and fill in your mailer settings
* Modify `silhouette.conf` and fill in with your silhouette settings
* Run project `sbt run`
* NB: First signed up user becomes admin!

# License

The code is licensed under [Apache License v2.0](http://www.apache.org/licenses/LICENSE-2.0).
