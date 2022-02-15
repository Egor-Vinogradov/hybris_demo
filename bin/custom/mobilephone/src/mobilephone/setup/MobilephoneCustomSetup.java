package mobilephone.setup;

import de.hybris.platform.core.initialization.SystemSetup;
import de.hybris.platform.servicelayer.impex.ImportConfig;
import de.hybris.platform.servicelayer.impex.ImportResult;
import de.hybris.platform.servicelayer.impex.ImportService;
import de.hybris.platform.servicelayer.impex.impl.StreamBasedImpExResource;

import java.io.InputStream;


@SystemSetup(extension = "mobilephone")
public class MobilephoneCustomSetup {
	private ImportService importService;
	public ImportService getImportService()
	{
		return importService;
	}
	public void setImportService(final ImportService importService)
	{
		this.importService = importService;
	}

	@SystemSetup(type = SystemSetup.Type.ESSENTIAL)
	public boolean putInMyEssentialData() {
		return true;
	}

	@SystemSetup(type = SystemSetup.Type.PROJECT)
	public boolean addMyProjectData() {
//		impexImport("/impex/concerttours-bands.impex");
//		impexImport("/impex/concerttours-bands-en.impex");
//		impexImport("/impex/concerttours-bands-de.impex");
//		impexImport("/impex/concerttours-bands-ru.impex");
//		impexImport("/impex/concerttours-yBandTour.impex");
		return true;
	}

	protected boolean impexImport(final String filename) {
		final String message = "Concerttours impexing [" + filename + "]...";

		try {
			final InputStream resourceAsStream = getClass().getResourceAsStream(filename);
			final ImportConfig importConfig = new ImportConfig();
			importConfig.setScript(new StreamBasedImpExResource(resourceAsStream, "UTF-8"));
			importConfig.setLegacyMode(Boolean.FALSE);
			final ImportResult importResult = getImportService().importData(importConfig);
			if (importResult.isError()) {
				return false;
			}
		} catch (final Exception e) {
			return false;
		}
		return true;
	}
}
