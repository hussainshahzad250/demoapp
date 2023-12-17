# To create ECR repository

Run below commands
1.  ``` pip install -r requirement.txt ```

2.  ``` python3 ecr.py ```

Build Docker image and push to ECR repository

3.  ``` docker build -t demoapp .   ```


Run docker image locally to test your application

``` docker run -p 8080:8080 demoapp```

4.  replace ```1234567890``` with your AWS account id in below commonds

``` aws ecr get-login-password --region ap-south-1 | docker login --username AWS --password-stdin 1234567890.dkr.ecr.ap-south-1.amazonaws.com ```

5.  tag docker image as per your account

``` docker tag demoapp:latest 1234567890.dkr.ecr.ap-south-1.amazonaws.com/demoapp:latest  ```

6.  Push docker image to ECR repository

``` docker push 1234567890.dkr.ecr.ap-south-1.amazonaws.com/demoapp:latest    ```
