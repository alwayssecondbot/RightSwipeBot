FROM jvalance/ubi7:7.7
LABEL authors="Ilya" version="7.7"

RUN set -eux; \
	yum install -y httpd; \
	httpd -v

ENV HTTPD_DIR=/var/www/html

RUN mkdir -m 755 -p $HTTPD_DIR \
    && chown root:root $HTTPD_DIR

ENV HTTPD_INDEX=index.html

COPY $HTTPD_INDEX $HTTPD_DIR

RUN chown root:root "$HTTPD_DIR/$HTTPD_INDEX" \
    && chmod 644 "$HTTPD_DIR/$HTTPD_INDEX"


STOPSIGNAL SIGWINCH

EXPOSE 80
CMD ["/usr/sbin/httpd", "-D", "FOREGROUND"]