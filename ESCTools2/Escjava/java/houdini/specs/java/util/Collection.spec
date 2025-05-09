/*
 * @(#)Collection.java	1.25 98/09/30
 *
 * Copyright 1997, 1998 by Sun Microsystems, Inc.,
 * 901 San Antonio Road, Palo Alto, California, 94303, U.S.A.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of Sun Microsystems, Inc. ("Confidential Information").  You
 * shall not disclose such Confidential Information and shall use
 * it only in accordance with the terms of the license agreement
 * you entered into with Sun.
 */

package java.util;

/**
 * The root interface in the <i>collection hierarchy</i>.  A collection
 * represents a group of objects, known as its <i>elements</i>.  Some
 * collections allow duplicate elements and others do not.  Some are ordered
 * and others unordered.  The JDK does not provide any <i>direct</i>
 * implementations of this interface: it provides implementations of more
 * specific subinterfaces like <tt>Set</tt> and <tt>List</tt>.  This interface
 * is typically used to pass collections around and manipulate them where
 * maximum generality is desired.<p>
 *
 * <i>Bags</i> or <i>multisets</i> (unordered collections that may contain
 * duplicate elements) should implement this interface directly.<p>
 *
 * All general-purpose <tt>Collection</tt> implementation classes (which
 * typically implement <tt>Collection</tt> indirectly through one of its
 * subinterfaces) should provide two "standard" constructors: a void (no
 * arguments) constructor, which creates an empty collection, and a
 * constructor with a single argument of type <tt>Collection</tt>, which
 * creates a new collection with the same elements as its argument.  In
 * effect, the latter constructor allows the user to copy any collection,
 * producing an equivalent collection of the desired implementation type.
 * There is no way to enforce this convention (as interfaces cannot contain
 * constructors) but all of the general-purpose <tt>Collection</tt>
 * implementations in the JDK comply.<p>
 *
 * @author  Josh Bloch
 * @version 1.25 09/30/98
 * @see	    Set
 * @see	    List
 * @see	    Map
 * @see	    SortedSet
 * @see	    SortedMap
 * @see	    HashSet
 * @see	    TreeSet
 * @see	    ArrayList
 * @see	    LinkedList
 * @see	    Vector
 * @see     Collections
 * @see	    Arrays
 * @see	    AbstractCollection
 * @since   JDK1.2
 */

public interface Collection {
    /*
     * The (more specific) static type of our elements:
     */
    //@ ghost public \TYPE elementType;

    /*
     * True iff we are allowed to contain null:
     */
    //@ ghost public boolean containsNull;


    // Query Operations

    /**
     * Returns the number of elements in this collection.  If this collection
     * contains more than <tt>Integer.MAX_VALUE</tt> elements, returns
     * <tt>Integer.MAX_VALUE</tt>.
     * 
     * @return the number of elements in this collection
     */
    //@ ensures \result>=0;
    int size();

    /**
     * Returns <tt>true</tt> if this collection contains no elements.
     *
     * @returns <tt>true</tt> if this collection contains no elements
     */
    boolean isEmpty();

    /**
     * Returns <tt>true</tt> if this collection contains the specified
     * element.  More formally, returns <tt>true</tt> if and only if this
     * collection contains at least one element <tt>e</tt> such that
     * <tt>(o==null ? e==null : o.equals(e))</tt>.
     *
     * @param o element whose presence in this collection is to be tested.
     * @return <tt>true</tt> if this collection contains the specified
     *         element
     */
    //@ requires !containsNull ==> o != null;
    // //@ requires \typeof(o) <: elementType || o==null;
    boolean contains(Object o);

    /**
     * Returns an iterator over the elements in this collection.  There are no
     * guarantees concerning the order in which the elements are returned
     * (unless this collection is an instance of some class that provides a
     * guarantee).
     * 
     * @returns an <tt>Iterator</tt> over the elements in this collection
     */
    //@ ensures \result != null;
    //@ ensures \result.elementType == elementType;
    //@ ensures containsNull == \result.returnsNull;
    Iterator iterator();

    /**
     * Returns an array containing all of the elements in this collection.  If
     * the collection makes any guarantees as to what order its elements are
     * returned by its iterator, this method must return the elements in the
     * same order.<p>
     *
     * The returned array will be "safe" in that no references to it are
     * maintained by this collection.  (In other words, this method must
     * allocate a new array even if this collection is backed by an array).
     * The caller is thus free to modify the returned array.<p>
     *
     * This method acts as bridge between array-based and collection-based
     * APIs.
     *
     * @return an array containing all of the elements in this collection
     */
    //@ ensures \result != null;
    Object[] toArray();

    /**
     * Returns an array containing all of the elements in this collection
     * whose runtime type is that of the specified array.  If the collection
     * fits in the specified array, it is returned therein.  Otherwise, a new
     * array is allocated with the runtime type of the specified array and the
     * size of this collection.<p>
     *
     * If this collection fits in the specified array with room to spare
     * (i.e., the array has more elements than this collection), the element
     * in the array immediately following the end of the collection is set to
     * <tt>null</tt>.  This is useful in determining the length of this
     * collection <i>only</i> if the caller knows that this collection does
     * not contain any <tt>null</tt> elements.)<p>
     *
     * If this collection makes any guarantees as to what order its elements
     * are returned by its iterator, this method must return the elements in
     * the same order.<p>
     *
     * Like the <tt>toArray</tt> method, this method acts as bridge between
     * array-based and collection-based APIs.  Further, this method allows
     * precise control over the runtime type of the output array, and may,
     * under certain circumstances, be used to save allocation costs<p>
     *
     * Suppose <tt>l</tt> is a <tt>List</tt> known to contain only strings.
     * The following code can be used to dump the list into a newly allocated
     * array of <tt>String</tt>:
     *
     * <pre>
     *     String[] x = (String[]) v.toArray(new String[0]);
     * </pre><p>
     *
     * Note that <tt>toArray(new Object[0])</tt> is identical in function to
     * <tt>toArray()</tt>.
     *
     * @param the array into which the elements of this collection are to be
     *        stored, if it is big enough; otherwise, a new array of the same
     *        runtime type is allocated for this purpose.
     * @return an array containing the elements of this collection
     * 
     * @throws ArrayStoreException the runtime type of the specified array is
     *         not a supertype of the runtime type of every element in this
     *         collection.
     */
    //@ ensures \result != null;
    Object[] toArray(/*@non_null*/ Object a[]);

    // Modification Operations

    /**
     * Ensures that this collection contains the specified element (optional
     * operation).  Returns <tt>true</tt> if this collection changed as a
     * result of the call.  (Returns <tt>false</tt> if this collection does
     * not permit duplicates and already contains the specified element.)<p>
     *
     * Collections that support this operation may place limitations on what
     * elements may be added to this collection.  In particular, some
     * collections will refuse to add <tt>null</tt> elements, and others will
     * impose restrictions on the type of elements that may be added.
     * Collection classes should clearly specify in their documentation any
     * restrictions on what elements may be added.<p>
     *
     * If a collection refuses to add a particular element for any reason
     * other than that it already contains the element, it <i>must</i> throw
     * an exception (rather than returning <tt>false</tt>).  This preserves
     * the invariant that a collection always contains the specified element
     * after this call returns.
     *
     * @param o element whose presence in this collection is to be ensured.
     * @return <tt>true</tt> if this collection changed as a result of the
     *         call
     * 
     * @throws UnsupportedOperationException add is not supported by this
     *         collection.
     * @throws ClassCastException class of the specified element prevents it
     *         from being added to this collection.
     * @throws IllegalArgumentException some aspect of this element prevents
     *          it from being added to this collection.
     */
    //@ requires !containsNull ==> o != null;
    //@ requires \typeof(o) <: elementType || o==null;
    boolean add(Object o);

    /**
     * Removes a single instance of the specified element from this
     * collection, if it is present (optional operation).  More formally,
     * removes an element <tt>e</tt> such that <tt>(o==null ?  e==null :
     * o.equals(e))</tt>, if this collection contains one or more such
     * elements.  Returns true if this collection contained the specified
     * element (or equivalently, if this collection changed as a result of the
     * call).
     *
     * @param o element to be removed from this collection, if present.
     * @return <tt>true</tt> if this collection changed as a result of the
     *         call
     * 
     * @throws UnsupportedOperationException remove is not supported by this
     *         collection.
     */
    //@ requires !containsNull ==> o != null;
    //@ requires \typeof(o) <: elementType || o==null;
    boolean remove(Object o);


    // Bulk Operations

    /**
     * Returns <tt>true</tt> if this collection contains all of the elements
     * in the specified collection.
     *
     * @param c collection to be checked for containment in this collection.
     * @return <tt>true</tt> if this collection contains all of the elements
     *	       in the specified collection
     * @see #contains(Object)
     */
    //@ requires c.elementType <: elementType;
    //@ requires !containsNull ==> !c.containsNull;
    boolean containsAll(/*@non_null*/ Collection c);

    /**
     * Adds all of the elements in the specified collection to this collection
     * (optional operation).  The behavior of this operation is undefined if
     * the specified collection is modified while the operation is in progress.
     * (This implies that the behavior of this call is undefined if the
     * specified collection is this collection, and this collection is
     * nonempty.)
     *
     * @param c elements to be inserted into this collection.
     * @return <tt>true</tt> if this collection changed as a result of the
     *         call
     * 
     * @throws UnsupportedOperationException if this collection does not
     *         support the <tt>addAll</tt> method.
     * @throws ClassCastException if the class of an element of the specified
     * 	       collection prevents it from being added to this collection.
     * @throws IllegalArgumentException some aspect of an element of the
     *	       specified collection prevents it from being added to this
     *	       collection.
     * 
     * @see #add(Object)
     */
    //@ requires c.elementType <: elementType;
    //@ requires !containsNull ==> !c.containsNull;
    boolean addAll(/*@non_null*/ Collection c);

    /**
     * 
     * Removes all this collection's elements that are also contained in the
     * specified collection (optional operation).  After this call returns,
     * this collection will contain no elements in common with the specified
     * collection.
     *
     * @param c elements to be removed from this collection.
     * @return <tt>true</tt> if this collection changed as a result of the
     *         call
     * 
     * @throws UnsupportedOperationException if the <tt>removeAll</tt> method
     * 	       is not supported by this collection.
     * 
     * @see #remove(Object)
     * @see #contains(Object)
     */
    //@ requires elementType <: c.elementType;
    //@ requires !c.containsNull ==> !containsNull;
    boolean removeAll(/*@non_null*/ Collection c);

    /**
     * Retains only the elements in this collection that are contained in the
     * specified collection (optional operation).  In other words, removes from
     * this collection all of its elements that are not contained in the
     * specified collection.
     *
     * @param c elements to be retained in this collection.
     * @return <tt>true</tt> if this collection changed as a result of the
     *         call
     * 
     * @throws UnsupportedOperationException if the <tt>retainAll</tt> method
     * 	       is not supported by this Collection.
     * 
     * @see #remove(Object)
     * @see #contains(Object)
     */
    //@ requires elementType <: c.elementType;
    //@ requires !c.containsNull ==> !containsNull;
    boolean retainAll(/*@non_null*/ Collection c);

    /**
     * Removes all of the elements from this collection (optional operation).
     * This collection will be empty after this method returns unless it
     * throws an exception.
     *
     * @throws UnsupportedOperationException if the <tt>clear</tt> method is
     *         not supported by this collection.
     */
    void clear();


    // Comparison and hashing

    /**
     * Compares the specified object with this collection for equality. <p>
     *
     * While the <tt>Collection</tt> interface adds no stipulations to the
     * general contract for the <tt>Object.equals</tt>, programmers who
     * implement the <tt>Collection</tt> interface "directly" (in other words,
     * create a class that is a <tt>Collection</tt> but is not a <tt>Set</tt>
     * or a <tt>List</tt>) must exercise care if they choose to override the
     * <tt>Object.equals</tt>.  It is not necessary to do so, and the simplest
     * course of action is to rely on <tt>Object</tt>'s implementation, but
     * the implementer may wish to implement a "value comparison" in place of
     * the default "reference comparison."  (The <tt>List</tt> and
     * <tt>Set</tt> interfaces mandate such value comparisons.)<p>
     *
     * The general contract for the <tt>Object.equals</tt> method states that
     * equals must be symmetric (in other words, <tt>a.equals(b)</tt> if and
     * only if <tt>b.equals(a)</tt>).  The contracts for <tt>List.equals</tt>
     * and <tt>Set.equals</tt> state that lists are only equal to other lists,
     * and sets to other sets.  Thus, a custom <tt>equals</tt> method for a
     * collection class that implements neither the <tt>List</tt> nor
     * <tt>Set</tt> interface must return <tt>false</tt> when this collection
     * is compared to any list or set.  (By the same logic, it is not possible
     * to write a class that correctly implements both the <tt>Set</tt> and
     * <tt>List</tt> interfaces.)
     *
     * @param o Object to be compared for equality with this collection.
     * @return <tt>true</tt> if the specified object is equal to this
     * collection
     * 
     * @see Object#equals(Object)
     * @see Set#equals(Object)
     * @see List#equals(Object)
     */
    boolean equals(Object o);

    /**
     * 
     * Returns the hash code value for this collection.  While the
     * <tt>Collection</tt> interface adds no stipulations to the general
     * contract for the <tt>Object.hashCode</tt> method, programmers should
     * take note that any class that overrides the <tt>Object.equals</tt>
     * method must also override the <tt>Object.hashCode</tt> method in order
     * to satisfy the general contract for the <tt>Object.hashCode</tt>method.
     * In particular, <tt>c1.equals(c2)</tt> implies that
     * <tt>c1.hashCode()==c2.hashCode()</tt>.
     *
     * @return the hash code value for this collection
     * 
     * @see Object#hashCode()
     * @see Object#equals(Object)
     */
    int hashCode();
}
