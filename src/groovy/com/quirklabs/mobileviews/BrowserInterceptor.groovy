package com.quirklabs.mobileviews

class BrowserInterceptor {

    def afterInterceptor = { model, modelAndView ->

        if (modelAndView && request && MobileService.isMobile(request)) {
            modelAndView.viewName = '/mobile/' + modelAndView.viewName
        }
    }
}
