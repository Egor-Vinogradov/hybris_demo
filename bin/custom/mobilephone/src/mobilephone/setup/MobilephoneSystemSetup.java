/*
 * [y] hybris Platform
 *
 * Copyright (c) 2017 SAP SE or an SAP affiliate company.  All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 */
package mobilephone.setup;

import static mobilephone.constants.MobilephoneConstants.PLATFORM_LOGO_CODE;

import de.hybris.platform.core.initialization.SystemSetup;

import java.io.InputStream;

import mobilephone.constants.MobilephoneConstants;
import mobilephone.service.MobilephoneService;


@SystemSetup(extension = MobilephoneConstants.EXTENSIONNAME)
public class MobilephoneSystemSetup
{
	private final MobilephoneService mobilephoneService;

	public MobilephoneSystemSetup(final MobilephoneService mobilephoneService)
	{
		this.mobilephoneService = mobilephoneService;
	}

	@SystemSetup(process = SystemSetup.Process.INIT, type = SystemSetup.Type.ESSENTIAL)
	public void createEssentialData()
	{
		mobilephoneService.createLogo(PLATFORM_LOGO_CODE);
	}

	private InputStream getImageStream()
	{
		return MobilephoneSystemSetup.class.getResourceAsStream("/mobilephone/sap-hybris-platform.png");
	}
}
