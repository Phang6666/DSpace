/**
 * The contents of this file are subject to the license and copyright
 * detailed in the LICENSE and NOTICE files at the root of the source
 * tree and available online at
 *
 * http://www.dspace.org/license/
 */
package org.dspace.app.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.dspace.app.rest.test.AbstractControllerIntegrationTest;
import org.junit.Test;

public class LDNInboxControllerIT extends AbstractControllerIntegrationTest {

    @Test
    public void ldnInboxEndorsementActionTest() throws Exception {
        String message = "{\n" +
            "  \"@context\": [\n" +
            "    \"https://www.w3.org/ns/activitystreams\",\n" +
            "    \"https://purl.org/coar/notify\"\n" +
            "  ],\n" +
            "  \"actor\": {\n" +
            "    \"id\": \"https://orcid.org/0000-0002-1825-0097\",\n" +
            "    \"name\": \"Josiah Carberry\",\n" +
            "    \"type\": \"Person\"\n" +
            "  },\n" +
            "  \"id\": \"urn:uuid:0370c0fb-bb78-4a9b-87f5-bed307a509dd\",\n" +
            "  \"object\": {\n" +
            "    \"id\": \"https://research-organisation.org/repository/preprint/201203/421/\",\n" +
            "    \"ietf:cite-as\": \"https://doi.org/10.5555/12345680\",\n" +
            "    \"type\": \"sorg:AboutPage\",\n" +
            "    \"url\": {\n" +
            "      \"id\": \"https://research-organisation.org/repository/preprint/201203/421/content.pdf\",\n" +
            "      \"mediaType\": \"application/pdf\",\n" +
            "      \"type\": [\n" +
            "        \"Article\",\n" +
            "        \"sorg:ScholarlyArticle\"\n" +
            "      ]\n" +
            "    }\n" +
            "  },\n" +
            "  \"origin\": {\n" +
            "    \"id\": \"https://research-organisation.org/repository\",\n" +
            "    \"inbox\": \"https://research-organisation.org/inbox/\",\n" +
            "    \"type\": \"Service\"\n" +
            "  },\n" +
            "  \"target\": {\n" +
            "    \"id\": \"https://overlay-journal.com/system\",\n" +
            "    \"inbox\": \"https://overlay-journal.com/inbox/\",\n" +
            "    \"type\": \"Service\"\n" +
            "  },\n" +
            "  \"type\": [\n" +
            "    \"Offer\",\n" +
            "    \"coar-notify:EndorsementAction\"\n" +
            "  ]\n" +
            "}";

        getClient(getAuthToken(admin.getEmail(), password))
            .perform(post("/ldn/inbox")
                .contentType("application/ld+json")
                .content(message))
            .andExpect(status().isCreated());
    }

    @Test
    public void ldnInboxAnnounceEndorsementTest() throws Exception {
        String message = "{\n" +
            "  \"@context\": [\n" +
            "    \"https://www.w3.org/ns/activitystreams\",\n" +
            "    \"https://purl.org/coar/notify\"\n" +
            "  ],\n" +
            "  \"actor\": {\n" +
            "    \"id\": \"https://overlay-journal.com\",\n" +
            "    \"name\": \"Overlay Journal\",\n" +
            "    \"type\": \"Service\"\n" +
            "  },\n" +
            "  \"context\": {\n" +
            "    \"id\": \"https://research-organisation.org/repository/preprint/201203/421/\",\n" +
            "    \"ietf:cite-as\": \"https://doi.org/10.5555/12345680\",\n" +
            "    \"type\": \"sorg:AboutPage\",\n" +
            "    \"url\": {\n" +
            "      \"id\": \"https://research-organisation.org/repository/preprint/201203/421/content.pdf\",\n" +
            "      \"mediaType\": \"application/pdf\",\n" +
            "      \"type\": [\n" +
            "        \"Article\",\n" +
            "        \"sorg:ScholarlyArticle\"\n" +
            "      ]\n" +
            "    }\n" +
            "  },\n" +
            "  \"id\": \"urn:uuid:94ecae35-dcfd-4182-8550-22c7164fe23f\",\n" +
            "  \"inReplyTo\": \"urn:uuid:0370c0fb-bb78-4a9b-87f5-bed307a509dd\",\n" +
            "  \"object\": {\n" +
            "    \"id\": \"https://overlay-journal.com/articles/00001/\",\n" +
            "    \"ietf:cite-as\": \"https://overlay-journal.com/articles/00001/\",\n" +
            "    \"type\": [\n" +
            "      \"Page\",\n" +
            "      \"sorg:WebPage\"\n" +
            "    ]\n" +
            "  },\n" +
            "  \"origin\": {\n" +
            "    \"id\": \"https://overlay-journal.com/system\",\n" +
            "    \"inbox\": \"https://overlay-journal.com/inbox/\",\n" +
            "    \"type\": \"Service\"\n" +
            "  },\n" +
            "  \"target\": {\n" +
            "    \"id\": \"https://research-organisation.org/repository\",\n" +
            "    \"inbox\": \"https://research-organisation.org/inbox/\",\n" +
            "    \"type\": \"Service\"\n" +
            "  },\n" +
            "  \"type\": [\n" +
            "    \"Announce\",\n" +
            "    \"coar-notify:EndorsementAction\"\n" +
            "  ]\n" +
            "}";

        getClient(getAuthToken(admin.getEmail(), password))
            .perform(post("/ldn/inbox")
                .contentType("application/ld+json")
                .content(message))
            .andExpect(status().isCreated());
    }

}
