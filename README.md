Grails Mobile Views Plugin
==========================

The mobile views plugin provides automatic switching between 'desktop' and 'mobile' views (gsp's) based on whether the browsing device is a desktop or mobile device.

It uses the Spring Mobile plugin to do device detection using WURFL.


Usage
=====

All mobile views go in a 'mobile' folder in views. The folder and file structure within the mobile must replicated that of the view folder - for example the mobile view for views/home/index.gsp will be views/mobile/home/index.gsp

All controllers which need their views switched between mobile and desktop versions need to have an afterInterceptor defined to handle the switching:

def afterInterceptor = [action: new BrowserInterceptor().afterInterceptor]


Limitations
===========

Because Grails only makes the model and view available to afterInterceptors, on the view is switched by the plugin. So partial templates and iterated renders of collections are not switched automatically. Basically this means that views should be switched and any device-specific partial templates should be rendered from the appropriate main view.
