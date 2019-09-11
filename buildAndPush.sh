docker build -t app .
docker tag fiona-hello-world:latest 945367126992.dkr.ecr.ap-southeast-2.amazonaws.com/fiona-hello-world:latest
$(aws ecr get-login --no-include-email --region ap-southeast-2)
docker push 945367126992.dkr.ecr.ap-southeast-2.amazonaws.com/fiona-hello-world:latest