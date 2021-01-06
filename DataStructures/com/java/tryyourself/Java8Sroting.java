package com.java.tryyourself;


import java.util.*;
import java.util.Map;
import java.util.stream.Collectors;

public class Java8Sroting {

	public static void main(String[] s) {
		List<Customer> cusL = new ArrayList<Customer>();
		cusL.add(new Customer("shyam", "negi", Membership.BAS, null));
		cusL.add(new Customer("nitin", "bisht", Membership.BAS, null));

		cusL.add(new Customer("ram", "negi", Membership.PRIM, "shyam"));
		cusL.add(new Customer("suri", "negi", Membership.LOC, "shyam"));

		cusL.add(new Customer("kamal", "bisht", Membership.BAS, "nitin"));
		cusL.add(new Customer("deep", "bisht", Membership.LOC, "nitin"));

		cusL.add(new Customer("raj", "sharma", Membership.PRIM, null));

		List<Customer> parentList = cusL.stream().filter(p -> p.parent == null).collect(Collectors.toList());
		System.out.println(parentList);
		List<Customer> childList = cusL.stream().filter(p -> p.parent != null).collect(Collectors.toList());
		System.out.println(childList);

		Comparator<Customer> com = (a, b) -> {
			Membership m1 = getChidMember(a, childList);
			Membership m2 = getChidMember(b, childList);
			m1 = m1 == null ? a.mem : m1;
			m2 = m2 == null ? b.mem : m2;
			return Integer.compare(m2.val, m1.val);
		};

		Map<String, List<Customer>> mapCus = cusL.stream()
				.collect(Collectors.groupingBy(p -> p.parent == null ? "parent" : p.parent));

		System.out.println(mapCus);
		List<Customer> sortParent = mapCus.get("parent").stream().sorted(com).collect(Collectors.toList());
		List<Customer> sortCus = new LinkedList<>();
		for (Customer c : sortParent) {
			sortCus.add(c);
			if (mapCus.get(c.name) != null) {
				List<Customer> child = mapCus.get(c.name).stream().sorted((a, b) -> a.name.compareTo(b.name))
						.collect(Collectors.toList());
				sortCus.addAll(child);
			}
		}
		System.out.println(sortCus);
	}

	static Membership getChidMember(Customer parent, List<Customer> childList) {
		List<Customer> cu = childList.stream().filter(p -> (p.parent.equals(parent.name) && p.mem.val > parent.mem.val))
				.sorted((a, b) -> Integer.compare(b.mem.val, a.mem.val)).limit(1).collect(Collectors.toList());
		return cu.size() != 0 ? cu.get(0).mem : null;
	}

}

class Customer {
	Membership mem;
	String name;
	String lastName;
	String parent;

	public String getParent() {
		return parent;
	}

	public void setParent(String parent) {
		this.parent = parent;
	}

	public Customer(String name, String lastName, Membership mem, String parent) {
		this.mem = mem;
		this.name = name;
		this.lastName = lastName;
		this.parent = parent;
	}

	@Override
	public String toString() {
		return this.name;
	}

}

enum Membership {
	PRIM(3), LOC(2), BAS(1);
	int val;

	Membership(int val) {
		this.val = val;
	}

	int getValue() {
		return val;
	}
}