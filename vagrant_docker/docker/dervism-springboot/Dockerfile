FROM dervism/dockerjava:jre8
MAINTAINER dervis4@gmail.com
EXPOSE 8080

RUN apk update && apk add wget && wget --no-check-certificate "https://bintray.com/artifact/download/dervism/maven/springboot.testapp-1.0.jar"

CMD java -jar springboot.testapp-1.0.jar