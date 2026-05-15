FROM ollama/ollama:rocm
LABEL authors="Ilya" version="0.1a"

RUN /usr/bin/ollama

STOPSIGNAL SIGWINCH