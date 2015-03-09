FROM centos

RUN yum -y install java-1.7.0-openjdk-devel.x86_64 

ADD target/training.jar /
ADD src/main/conf/training-local.yml /

CMD ["java", "-jar", "training.jar", "server", "training-local.yml"]

EXPOSE 8080
