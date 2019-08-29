//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.2-147 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.08.25 at 06:42:46 PM CEST 
//


package com.megatravel.model;

import javax.xml.bind.annotation.XmlRegistry;

import com.megatravel.dto.soap.CodebookResponse;
import com.megatravel.dto.soap.CprdCommentResponse;
import com.megatravel.dto.soap.CreateAccommodationCategoryRequest;
import com.megatravel.dto.soap.CreateAccommodationRequest;
import com.megatravel.dto.soap.CreateAccommodationTypeRequest;
import com.megatravel.dto.soap.CreateAdditionalServiceRequest;
import com.megatravel.dto.soap.CreateAgentRequest;
import com.megatravel.dto.soap.CreateCommentRequest;
import com.megatravel.dto.soap.CreateEndUserRequest;
import com.megatravel.dto.soap.CreateMessageRequest;
import com.megatravel.dto.soap.CreateMessageResponse;
import com.megatravel.dto.soap.CreateReservationRequest;
import com.megatravel.dto.soap.CudAccommodationResponse;
import com.megatravel.dto.soap.CudReservationResponse;
import com.megatravel.dto.soap.DeleteAccommodationCategoryRequest;
import com.megatravel.dto.soap.DeleteAccommodationRequest;
import com.megatravel.dto.soap.DeleteAccommodationTypeRequest;
import com.megatravel.dto.soap.DeleteAdditionalServiceRequest;
import com.megatravel.dto.soap.DeleteCommentRequest;
import com.megatravel.dto.soap.UpdateAccommodationCategoryRequest;
import com.megatravel.dto.soap.UpdateAccommodationRequest;
import com.megatravel.dto.soap.UpdateAccommodationTypeRequest;
import com.megatravel.dto.soap.UpdateAdditionalServiceRequest;
import com.megatravel.dto.soap.UpdateCommentRequest;
import com.megatravel.dto.soap.UpdateReservationRequest;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.megatravel.accommodation package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.megatravel.accommodation
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ImageResource }
     * 
     */
    public ImageResource createImageResource() {
        return new ImageResource();
    }

    /**
     * Create an instance of {@link CreateAccommodationRequest.Cancellation }
     * 
     */
    public CreateAccommodationRequest.Cancellation createCreateAccommodationRequestCancellation() {
        return new CreateAccommodationRequest.Cancellation();
    }

    /**
     * Create an instance of {@link DeleteCommentRequest }
     * 
     */
    public DeleteCommentRequest createDeleteCommentRequest() {
        return new DeleteCommentRequest();
    }

    /**
     * Create an instance of {@link CreateCommentRequest }
     * 
     */
    public CreateCommentRequest createCreateCommentRequest() {
        return new CreateCommentRequest();
    }

    /**
     * Create an instance of {@link Address }
     * 
     */
    public Address createAddress() {
        return new Address();
    }

    /**
     * Create an instance of {@link UpdateAccommodationRequest }
     * 
     */
    public UpdateAccommodationRequest createUpdateAccommodationRequest() {
        return new UpdateAccommodationRequest();
    }

    /**
     * Create an instance of {@link CreateAccommodationRequest }
     * 
     */
    public CreateAccommodationRequest createCreateAccommodationRequest() {
        return new CreateAccommodationRequest();
    }

    /**
     * Create an instance of {@link Comment }
     * 
     */
    public Comment createComment() {
        return new Comment();
    }

    /**
     * Create an instance of {@link CreateAccommodationRequest.Pricelist }
     * 
     */
    public CreateAccommodationRequest.Pricelist createCreateAccommodationRequestPricelist() {
        return new CreateAccommodationRequest.Pricelist();
    }

    /**
     * Create an instance of {@link com.megatravel.accommodation.Cancellation }
     * 
     */
    public Cancellation createCancellation() {
        return new Cancellation();
    }

    /**
     * Create an instance of {@link UpdateAccommodationRequest.Cancellation }
     * 
     */
    public UpdateAccommodationRequest.Cancellation createUpdateAccommodationRequestCancellation() {
        return new UpdateAccommodationRequest.Cancellation();
    }

    /**
     * Create an instance of {@link Rate }
     * 
     */
    public Rate createRate() {
        return new Rate();
    }

    /**
     * Create an instance of {@link CudAccommodationResponse }
     * 
     */
    public CudAccommodationResponse createCudAccommodationResponse() {
        return new CudAccommodationResponse();
    }

    /**
     * Create an instance of {@link CprdCommentResponse }
     * 
     */
    public CprdCommentResponse createCprdCommentResponse() {
        return new CprdCommentResponse();
    }

    /**
     * Create an instance of {@link UpdateAccommodationRequest.Pricelist }
     * 
     */
    public UpdateAccommodationRequest.Pricelist createUpdateAccommodationRequestPricelist() {
        return new UpdateAccommodationRequest.Pricelist();
    }

    /**
     * Create an instance of {@link DeleteAccommodationRequest }
     * 
     */
    public DeleteAccommodationRequest createDeleteAccommodationRequest() {
        return new DeleteAccommodationRequest();
    }

    /**
     * Create an instance of {@link Accommodation }
     * 
     */
    public Accommodation createAccommodation() {
        return new Accommodation();
    }

    /**
     * Create an instance of {@link UpdateCommentRequest }
     * 
     */
    public UpdateCommentRequest createUpdateCommentRequest() {
        return new UpdateCommentRequest();
    }

    /**
     * Create an instance of {@link PriceInSeason }
     * 
     */
    public PriceInSeason createPriceInSeason() {
        return new PriceInSeason();
    }
    
    /**
     * Create an instance of {@link Agent }
     * 
     */
    public Agent createAgent() {
        return new Agent();
    }

    /**
     * Create an instance of {@link CreateEndUserRequest }
     * 
     */
    public CreateEndUserRequest createCreateEndUserRequest() {
        return new CreateEndUserRequest();
    }

    /**
     * Create an instance of {@link EndUser }
     * 
     */
    public EndUser createEndUser() {
        return new EndUser();
    }

    /**
     * Create an instance of {@link Role }
     * 
     */
    public Role createRole() {
        return new Role();
    }

    /**
     * Create an instance of {@link CreateAgentRequest }
     * 
     */
    public CreateAgentRequest createCreateAgentRequest() {
        return new CreateAgentRequest();
    }

    /**
     * Create an instance of {@link Privileges }
     * 
     */
    public Privileges createPrivileges() {
        return new Privileges();
    }

    /**
     * Create an instance of {@link UserResponse }
     * 
     */
    public UserResponse createUserResponse() {
        return new UserResponse();
    }

    /**
     * Create an instance of {@link Administrator }
     * 
     */
    public Administrator createAdministrator() {
        return new Administrator();
    }
    
    /**
     * Create an instance of {@link DeleteAccommodationCategoryRequest }
     * 
     */
    public DeleteAccommodationCategoryRequest createDeleteAccommodationCategoryRequest() {
        return new DeleteAccommodationCategoryRequest();
    }

    /**
     * Create an instance of {@link CreateAccommodationTypeRequest }
     * 
     */
    public CreateAccommodationTypeRequest createCreateAccommodationTypeRequest() {
        return new CreateAccommodationTypeRequest();
    }

    /**
     * Create an instance of {@link UpdateAccommodationTypeRequest }
     * 
     */
    public UpdateAccommodationTypeRequest createUpdateAccommodationTypeRequest() {
        return new UpdateAccommodationTypeRequest();
    }

    /**
     * Create an instance of {@link UpdateAccommodationCategoryRequest }
     * 
     */
    public UpdateAccommodationCategoryRequest createUpdateAccommodationCategoryRequest() {
        return new UpdateAccommodationCategoryRequest();
    }

    /**
     * Create an instance of {@link DeleteAdditionalServiceRequest }
     * 
     */
    public DeleteAdditionalServiceRequest createDeleteAdditionalServiceRequest() {
        return new DeleteAdditionalServiceRequest();
    }

    /**
     * Create an instance of {@link CodebookResponse }
     * 
     */
    public CodebookResponse createCodebookResponse() {
        return new CodebookResponse();
    }

    /**
     * Create an instance of {@link CreateAccommodationCategoryRequest }
     * 
     */
    public CreateAccommodationCategoryRequest createCreateAccommodationCategoryRequest() {
        return new CreateAccommodationCategoryRequest();
    }

    /**
     * Create an instance of {@link UpdateAdditionalServiceRequest }
     * 
     */
    public UpdateAdditionalServiceRequest createUpdateAdditionalServiceRequest() {
        return new UpdateAdditionalServiceRequest();
    }

    /**
     * Create an instance of {@link AdditionalService }
     * 
     */
    public AdditionalService createAdditionalService() {
        return new AdditionalService();
    }

    /**
     * Create an instance of {@link AccommodationCategory }
     * 
     */
    public AccommodationCategory createAccommodationCategory() {
        return new AccommodationCategory();
    }

    /**
     * Create an instance of {@link DeleteAccommodationTypeRequest }
     * 
     */
    public DeleteAccommodationTypeRequest createDeleteAccommodationTypeRequest() {
        return new DeleteAccommodationTypeRequest();
    }

    /**
     * Create an instance of {@link CreateAdditionalServiceRequest }
     * 
     */
    public CreateAdditionalServiceRequest createCreateAdditionalServiceRequest() {
        return new CreateAdditionalServiceRequest();
    }

    /**
     * Create an instance of {@link AccommodationType }
     * 
     */
    public AccommodationType createAccommodationType() {
        return new AccommodationType();
    }
    
    /**
     * Create an instance of {@link CreateMessageRequest }
     * 
     */
    public CreateMessageRequest createCreateMessageRequest() {
        return new CreateMessageRequest();
    }

    /**
     * Create an instance of {@link Message }
     * 
     */
    public Message createMessage() {
        return new Message();
    }

    /**
     * Create an instance of {@link CreateMessageResponse }
     * 
     */
    public CreateMessageResponse createCreateMessageResponse() {
        return new CreateMessageResponse();
    }
    
    /**
     * Create an instance of {@link UpdateReservationRequest }
     * 
     */
    public UpdateReservationRequest createUpdateReservationRequest() {
        return new UpdateReservationRequest();
    }

    /**
     * Create an instance of {@link CudReservationResponse }
     * 
     */
    public CudReservationResponse createCudReservationResponse() {
        return new CudReservationResponse();
    }

    /**
     * Create an instance of {@link CreateReservationRequest }
     * 
     */
    public CreateReservationRequest createCreateReservationRequest() {
        return new CreateReservationRequest();
    }

    /**
     * Create an instance of {@link Reservation }
     * 
     */
    public Reservation createReservation() {
        return new Reservation();
    }


}
