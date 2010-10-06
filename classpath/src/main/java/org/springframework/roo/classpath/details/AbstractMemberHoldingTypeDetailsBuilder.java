package org.springframework.roo.classpath.details;

import java.util.ArrayList;
import java.util.List;

import org.springframework.roo.model.Builder;
import org.springframework.roo.model.JavaType;

/**
 * Abstract {@link Builder} to assist building {@link MemberHoldingTypeDetails} implementations.
 * 
 * @author Ben Alex
 * @since 1.1
 */
public abstract class AbstractMemberHoldingTypeDetailsBuilder<T extends MemberHoldingTypeDetails> extends AbstractIdentifiableAnnotatedJavaStructureBuilder<T> {
	private List<ConstructorMetadataBuilder> declaredConstructors = new ArrayList<ConstructorMetadataBuilder>();
	private List<FieldMetadataBuilder> declaredFields = new ArrayList<FieldMetadataBuilder>();
	private List<MethodMetadataBuilder> declaredMethods = new ArrayList<MethodMetadataBuilder>();
	private List<JavaType> extendsTypes = new ArrayList<JavaType>();
	private List<JavaType> implementsTypes = new ArrayList<JavaType>();
	
	protected AbstractMemberHoldingTypeDetailsBuilder(String declaredbyMetadataId) {
		super(declaredbyMetadataId);
	}
	
	protected AbstractMemberHoldingTypeDetailsBuilder(MemberHoldingTypeDetails existing) {
		super(existing);
		for (ConstructorMetadata element : existing.getDeclaredConstructors()) {
			declaredConstructors.add(new ConstructorMetadataBuilder(element));
		}
		for (FieldMetadata element : existing.getDeclaredFields()) {
			declaredFields.add(new FieldMetadataBuilder(element));
		}
		for (MethodMetadata element : existing.getDeclaredMethods()) {
			declaredMethods.add(new MethodMetadataBuilder(element));
		}
		extendsTypes.addAll(existing.getExtendsTypes());
		implementsTypes.addAll(existing.getImplementsTypes());
	}

	public final List<ConstructorMetadataBuilder> getDeclaredConstructors() {
		return declaredConstructors;
	}

	public final void setDeclaredConstructors(List<ConstructorMetadataBuilder> declaredConstructors) {
		this.declaredConstructors = declaredConstructors;
	}

	public final List<FieldMetadataBuilder> getDeclaredFields() {
		return declaredFields;
	}

	public final void setDeclaredFields(List<FieldMetadataBuilder> declaredFields) {
		this.declaredFields = declaredFields;
	}

	public final List<MethodMetadataBuilder> getDeclaredMethods() {
		return declaredMethods;
	}

	public final void setDeclaredMethods(List<MethodMetadataBuilder> declaredMethods) {
		this.declaredMethods = declaredMethods;
	}

	public final List<JavaType> getExtendsTypes() {
		return extendsTypes;
	}

	public final void setExtendsTypes(List<JavaType> extendsTypes) {
		this.extendsTypes = extendsTypes;
	}

	public final List<JavaType> getImplementsTypes() {
		return implementsTypes;
	}

	public final void setImplementsTypes(List<JavaType> implementsTypes) {
		this.implementsTypes = implementsTypes;
	}

	public final boolean addConstructor(ConstructorMetadataBuilder constructor) {
		if (constructor == null || !getDeclaredByMetadataId().equals(constructor.getDeclaredByMetadataId())) {
			return false;
		}
		onAddConstructor(constructor);
		return declaredConstructors.add(constructor);
	}

	protected void onAddConstructor(ConstructorMetadataBuilder constructor) {}
	
	public final boolean addField(FieldMetadataBuilder field) {
		if (field == null || !getDeclaredByMetadataId().equals(field.getDeclaredByMetadataId())) {
			return false;
		}
		onAddField(field);
		return declaredFields.add(field);
	}

	protected void onAddField(FieldMetadataBuilder field) {}

	public final boolean addMethod(MethodMetadataBuilder method) {
		if (method == null || !getDeclaredByMetadataId().equals(method.getDeclaredByMetadataId())) {
			return false;
		}
		onAddMethod(method);
		return declaredMethods.add(method);
	}

	protected void onAddMethod(MethodMetadataBuilder method) {}

	public final boolean addConstructor(ConstructorMetadata constructor) {
		if (constructor == null) return false;
		return addConstructor(new ConstructorMetadataBuilder(constructor));
	}

	public final boolean addField(FieldMetadata field) {
		if (field == null) return false;
		return addField(new FieldMetadataBuilder(field));
	}

	public final boolean addMethod(MethodMetadata method) {
		if (method == null) return false;
		return addMethod(new MethodMetadataBuilder(method));
	}

	public final boolean addImplementsType(JavaType implementsType) {
		if (implementsType == null) return false;
		onAddImplementType(implementsType);
		return implementsTypes.add(implementsType);
	}
	
	protected void onAddImplementType(JavaType implementsType) {}
	
	public final boolean addExtendsTypes(JavaType extendsType) {
		if (extendsType == null) return false;
		onAddExtendsTypes(extendsType);
		return extendsTypes.add(extendsType);
	}

	protected void onAddExtendsTypes(JavaType extendsType) {}

	public final List<ConstructorMetadata> buildConstructors() {
		List<ConstructorMetadata> result = new ArrayList<ConstructorMetadata>();
		for (ConstructorMetadataBuilder builder : declaredConstructors) {
			result.add(builder.build());
		}
		return result;
	}

	public final List<FieldMetadata> buildFields() {
		List<FieldMetadata> result = new ArrayList<FieldMetadata>();
		for (FieldMetadataBuilder builder : declaredFields) {
			result.add(builder.build());
		}
		return result;
	}

	public final List<MethodMetadata> buildMethods() {
		List<MethodMetadata> result = new ArrayList<MethodMetadata>();
		for (MethodMetadataBuilder builder : declaredMethods) {
			result.add(builder.build());
		}
		return result;
	}
}