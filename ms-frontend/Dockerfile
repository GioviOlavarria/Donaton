FROM nginx:alpine

# Copiar la configuración de nginx
COPY nginx.conf /etc/nginx/conf.d/default.conf

# Copiar el HTML de la landing page
COPY index.html /usr/share/nginx/html/index.html
COPY panel.html /usr/share/nginx/html/panel.html

EXPOSE 80

CMD ["nginx", "-g", "daemon off;"]
