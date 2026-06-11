<IfModule mod_rewrite.c>
    RewriteEngine On
    RewriteBase /JOSE_OLAYA_BALAMBRA/
    
    # No reescribir archivos reales
    RewriteCond %{REQUEST_FILENAME} !-f
    RewriteCond %{REQUEST_FILENAME} !-d
    
    # Reescribir todo a index.php
    RewriteRule ^(.*)$ index.php?url=$1 [QSA,L]
</IfModule>
