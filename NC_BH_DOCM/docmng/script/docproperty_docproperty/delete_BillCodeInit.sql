DELETE FROM pub_bcr_candiattr WHERE pk_nbcr = '0001ZZ1000000000PHMW';
DELETE FROM pub_bcr_elem WHERE pk_billcodebase in ( select pk_billcodebase from pub_bcr_RuleBase where nbcrcode = 'WDZX' );
DELETE FROM pub_bcr_RuleBase WHERE nbcrcode = 'WDZX';
DELETE FROM pub_bcr_nbcr WHERE pk_nbcr = '0001ZZ1000000000PHMW';
DELETE FROM pub_bcr_OrgRela WHERE pk_billcodebase = '0001ZZ1000000000PHMX';
DELETE FROM pub_bcr_RuleBase WHERE pk_billcodebase = '0001ZZ1000000000PHMX';
DELETE FROM pub_bcr_elem WHERE pk_billcodeelem = '0001ZZ1000000000PHMY';
DELETE FROM pub_bcr_elem WHERE pk_billcodeelem = '0001ZZ1000000000PHMZ';
DELETE FROM pub_bcr_elem WHERE pk_billcodeelem = '0001ZZ1000000000PHN0';
