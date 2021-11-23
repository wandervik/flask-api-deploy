FROM


FROM python:3

ENV DB_NAME=api \
    DB_HOST=localhost \
    DB_USER=api \
    DB_PASS=1234qwe

RUN mkdir -p /home/flask-api
COPY . /home/flask-api

WORKDIR /home/flask-api/api

RUN pip3 install -r requirements-dev.txt

CMD python3 -m app.app