docker build -t app .
docker tag fiona-hello-world:latest 945367126992.dkr.ecr.ap-southeast-2.amazonaws.com/fiona-hello-world:latest
docker push 945367126992.dkr.ecr.ap-southeast-2.amazonaws.com/fiona-hello-world:latest