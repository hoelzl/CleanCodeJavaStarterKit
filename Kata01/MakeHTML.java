package Kata01;

/**
 * RT = Rechte Maustaste
 * TODO 1 (Aus Einer langen Frunktion eine Klasse extrahieren)
 *  Function Body markieren
 *  RT => Refactor => Extract => Object Method....
 *  Create Inner Class, Name = 'SetupTeardownSurrounder'
 *  Visibility: Private
 *  Parameters: PageData pageData , boolean includeSuiteSetup
 *  ==========================================================
 *
 *  TODO 2 (Instanzvariablen aus lokalen Variablen Extrahieren und im Konstruktor initialisieren)
 *  Varialbe 'wikiPage' in invoke() Methode markieren
 *  RT => Refactor => Extract => Field....
 *  'Choose Class to Introduce Field' => 'SetupTeardownSurrounder'
 *  Doppelklick auf wikiPage.
 *  wikiPage im Konstruktor initializieren:
 *  dafür wikiPage = pageData.getWikiPage(); aus invoke in den 'SetupTeardownSurrounder' Konstruktor Body rein kopieren.
 *  Die gleichen Schritte für 'StringBuffer buffer' durchführen
 *  ==========================================================
 *
 *  TODO 3 (Eleminate Duplicate: Don't Repeate yourself! )
 *  Die folgende Struktur kommt 4 mal vor, Ähnliche Varianten mit geringfügigem Unterschied:
 *
 *  WikiPagePath pagePath = wikiPage.getPageCrawler().getFullPath(suiteSetup);
 *  String pagePathName = PathParser.render(pagePath);
 *  buffer.append("!include -setup .").append(pagePathName).append("\n");
 *
 *  TODO 3 ( Eliminate Duplicate: Elminate differences and extract a new Variable )
 *
 *   Idee: Eliminate Differences and Extract a new Variable,
 *   so that the three lines are parametric.
 *
 *   wikiPage.getPageCrawler() markieren
 *   Rechte Maustaste => Refactor => Extract => Field.. Name := 'crawler
 *   'crawler' im Konstrukor initializieren. crawler =  wikiPage.getPageCrawler();
 *
 *   Das gleiche für die String "setup" in buffer.append("!include -setup .")
 *   "setup" markieren => RT => Refactor => Extract => Variable => Name = mode
 *    'Replace all occurrences' auswählen.
 *
 *    Das gleiche für die String "teardown" in buffer.append("!include -setup .")
 *    "setup" markieren => RT => Refactor => Extract => Variable => Name = mode
 *    'Replace all occurrences' auswählen.
 *    ==========================================================
 *
 *
 */



public class MakeHTML {

    public static String testableHtml(PageData pageData, boolean includeSuiteSetup) throws Exception
    {
        WikiPage wikiPage = pageData.getWikiPage();
        StringBuffer buffer = new StringBuffer();
        if(pageData.hasAttribute("Test"))
        {
            if(includeSuiteSetup)
            {
                WikiPage suiteSetup = PageCrowlerImpl.getInheritedPage(SuiteResponder.SUITE_SETUP_NAME, wikiPage);
                if(suiteSetup != null)
                {
                    WikiPagePath pagePath = wikiPage.getPageCrawler().getFullPath(suiteSetup);
                    String pagePathName = PathParser.render(pagePath);
                    buffer.append("!include -setup .").append(pagePathName).append("\n");
                }
            }
            WikiPage setup = PageCrowlerImpl.getInheritedPage("SetUp", wikiPage);
            if(setup != null){
                WikiPagePath setupPath = wikiPage.getPageCrawler().getFullPath(setup);
                String setupPathName = PathParser.render(setupPath);
                buffer.append("!include -setup .").append(setupPathName).append("\n");
            }
        }
        buffer.append(pageData.getContent());
        if(pageData.hasAttribute("Test"))
        {
            WikiPage teardown = PageCrowlerImpl.getInheritedPage("TearDown", wikiPage);
            if(teardown != null){
                WikiPagePath tearDownPath = wikiPage.getPageCrawler().getFullPath(teardown);
                String tearDownPathName = PathParser.render(tearDownPath);
                buffer.append("!include -teardown .").append(tearDownPathName).append("\n");
            }
            if(includeSuiteSetup)
            {
                WikiPage suiteTeardown = PageCrowlerImpl.getInheritedPage(SuiteResponder.SUITE_TEARDOWN_NAME, wikiPage);
                if(suiteTeardown != null)
                {
                    WikiPagePath pagePath = suiteTeardown.getPageCrawler().getFullPath(suiteTeardown);
                    String pagePathName = PathParser.render(pagePath);
                    buffer.append("!include -teardown .").append(pagePathName).append("\n");
                }
            }
        }

        pageData.setContent(buffer.toString());
        return pageData.getHtml();
    }

}










