/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package behaviortree;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Traceability Status</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see behaviortree.BehaviortreePackage#getTraceabilityStatus()
 * @model
 * @generated
 */
public enum TraceabilityStatus implements Enumerator {
	/**
	 * The '<em><b>Original</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ORIGINAL_VALUE
	 * 
	 * @ordered
	 */
	ORIGINAL(0, "Original", ""),

	/**
	 * The '<em><b>Implied</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #IMPLIED_VALUE
	 * 
	 * @ordered
	 */
	IMPLIED(1, "Implied", "+"),

	/**
	 * The '<em><b>Missing</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MISSING_VALUE
	 * 
	 * @ordered
	 */
	MISSING(2, "Missing", "-"),

	/**
	 * The '<em><b>Updated</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #UPDATED_VALUE
	 * 
	 * @ordered
	 */
	UPDATED(3, "Updated", "++"),

	/**
	 * The '<em><b>Deleted</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DELETED_VALUE
	 * 
	 * @ordered
	 */
	DELETED(4, "Deleted", "--"),

	/**
	 * The '<em><b>Design Refinement</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DESIGN_REFINEMENT_VALUE
	 * 
	 * @ordered
	 */
	DESIGN_REFINEMENT(5, "DesignRefinement", "+-");

	/**
	 * The '<em><b>Original</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Original</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ORIGINAL
	 * @model name="Original" literal=""
	 * @generated
	 * @ordered
	 */
	public static final int ORIGINAL_VALUE = 0;

	/**
	 * The '<em><b>Implied</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Implied</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #IMPLIED
	 * @model name="Implied" literal="+"
	 * @generated
	 * @ordered
	 */
	public static final int IMPLIED_VALUE = 1;

	/**
	 * The '<em><b>Missing</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Missing</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MISSING
	 * @model name="Missing" literal="-"
	 * @generated
	 * @ordered
	 */
	public static final int MISSING_VALUE = 2;

	/**
	 * The '<em><b>Updated</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Updated</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #UPDATED
	 * @model name="Updated" literal="++"
	 * @generated
	 * @ordered
	 */
	public static final int UPDATED_VALUE = 3;

	/**
	 * The '<em><b>Deleted</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Deleted</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DELETED
	 * @model name="Deleted" literal="--"
	 * @generated
	 * @ordered
	 */
	public static final int DELETED_VALUE = 4;

	/**
	 * The '<em><b>Design Refinement</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Design Refinement</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DESIGN_REFINEMENT
	 * @model name="DesignRefinement" literal="+-"
	 * @generated
	 * @ordered
	 */
	public static final int DESIGN_REFINEMENT_VALUE = 5;

	/**
	 * An array of all the '<em><b>Traceability Status</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final TraceabilityStatus[] VALUES_ARRAY =
		new TraceabilityStatus[] {
			ORIGINAL,
			IMPLIED,
			MISSING,
			UPDATED,
			DELETED,
			DESIGN_REFINEMENT,
		};

	/**
	 * A public read-only list of all the '<em><b>Traceability Status</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<TraceabilityStatus> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Traceability Status</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static TraceabilityStatus get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			TraceabilityStatus result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Traceability Status</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static TraceabilityStatus getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			TraceabilityStatus result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Traceability Status</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static TraceabilityStatus get(int value) {
		switch (value) {
			case ORIGINAL_VALUE: return ORIGINAL;
			case IMPLIED_VALUE: return IMPLIED;
			case MISSING_VALUE: return MISSING;
			case UPDATED_VALUE: return UPDATED;
			case DELETED_VALUE: return DELETED;
			case DESIGN_REFINEMENT_VALUE: return DESIGN_REFINEMENT;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private TraceabilityStatus(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue() {
	  return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
	  return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLiteral() {
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}
	
} //TraceabilityStatus
