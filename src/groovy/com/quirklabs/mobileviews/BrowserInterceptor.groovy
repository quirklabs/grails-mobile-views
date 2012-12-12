package com.quirklabs.mobileviews

import javax.servlet.http.HttpSession
import org.springframework.web.context.request.RequestContextHolder

class BrowserInterceptor {

    def afterInterceptor = { model, modelAndView ->

        if(request?.queryString?.contains('qpv=mfd')) getSession()?.forceBrowser = 'mobile'
        else if(request?.queryString?.contains('qpv=dsk')) getSession()?.forceBrowser = 'desktop'

        if(modelAndView) {

            if(getSession().forceBrowser == 'mobile') modelAndView.viewName = '/mobile/' + modelAndView.viewName

            else if(getSession().forceBrowser == 'desktop') return

            else {
                if (request && MobileService.isMobile(request)) {
                    modelAndView.viewName = '/mobile/' + modelAndView.viewName
                }
            }
        }
    }

    private HttpSession getSession() {
        return RequestContextHolder.currentRequestAttributes().getSession()
    }
}
