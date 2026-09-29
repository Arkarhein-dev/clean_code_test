public class WikiPageResponder {

    // ==========================================
    // 1. HIGH-LEVEL CONCEPT (The "Headline" & "Synopsis")
    // ==========================================
    public Response makeResponse(FitNesseContext context, Request request) throws Exception {
        String pageName = getPageName(request);
        loadPage(pageName, context);

        if (doesPageExist()) {
            formatPageAsHtml();
        }

        return responseWriter.getResult();
    }

    // ==========================================
    // 2. MID-LEVEL DETAILS (Supporting methods)
    // ==========================================
    private void loadPage(String pageName, FitNesseContext context) {
        page = context.getRoot().findPage(pageName);
    }

    private void formatPageAsHtml() {
        String htmlContent = page.toHtml();
        responseWriter.setBody(htmlContent);
    }

    // ==========================================
    // 3. LOW-LEVEL DETAILS (The minutiae at the bottom)
    // ==========================================
    private String getPageName(Request request) {
        return request.getResource();
    }

    private boolean doesPageExist() {
        return page != null;
    }

    private Page page;
    private HtmlResponseWriter responseWriter = new HtmlResponseWriter();
}