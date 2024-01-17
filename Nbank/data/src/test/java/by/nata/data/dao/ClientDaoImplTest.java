package by.nata.data.dao;


//@ContextConfiguration(classes = DataConfigurationTest.class)
//@RunWith(SpringJUnit4ClassRunner.class)
//@TestPropertySource(value = "classpath:test.liquibase.properties")
public class ClientDaoImplTest {
//    private static final String CLIENT_ID = "1";
//    private static final String CLIENT_DETAILS_ID = "2";
//    private static final String CLIENT_ADDRESS_ID = "3";
//
//    @Autowired
//    private ClientDao clientDao;
//    @Autowired
//    private ClientDetailsDao clientDetailsDao;
//
//    @Autowired
//    private ClientAddressDao clientAddressDao;
//
//    Connection connection;
//    @Before
//    public void setUp() throws Exception {
//        connection = NbankTestDataSource.getConnection();
//    }
//
//    @After
//    public void tearDown() throws Exception {
//        clientDao = null;
//        clientDetailsDao = null;
//        clientAddressDao = null;
//    }

//    @Test
//    public void save() throws SQLException {
//       // String id = "4028e48f8d025c04018d025c091f0002";
//       // String testId = UUID.randomUUID().toString();
//        ClientDto clientDto = new ClientDto(CLIENT_ID,
//                "nata", "hjhj", "nat@gmail.com",Role.USER, new ClientDetailsDto(
//                CLIENT_DETAILS_ID, "Volkova", "Natali", LocalDate.of(2000, 8, 31),
//                "KB333333", "566767677",
//                LocalDate.of(2022, 12, 12),
//                LocalDate.of( 2030, 01, 01)),
//                new ClientAddressDto(CLIENT_ADDRESS_ID, "Belarus",  "Mogilev", "Pervomayskay",
//                        "32", "01", "22-22-22"));
//
//        clientDao.save(clientDto);
//
//        System.out.println(clientDto);
//
//        assertNotNull(clientDto);
//        assertEquals("nat@gmail.com", clientDto.getEmail());
//        assertEquals("nata", clientDto.getUsername());

       // dto.setProductImage(bytes);


//        ResultSet rs = connection.createStatement().executeQuery("SELECT count(*) FROM CLIENT WHERE name='NATALI'");
//        rs.next();
//       // String actualCount = rs.getString(id);
//        String actual = rs.getString();
////        assertEquals("4028e48f8d025c04018d025c091f0002", actualCount);
//        assertEquals("nata", );
    }

//    @Test
//    public void delete() {
//        ClientDto clientDto = new ClientDto(CLIENT_ID,
//                "nata", "hjhj", "nat@gmail.com", Role.USER, new ClientDetailsDto(
//                CLIENT_DETAILS_ID, "Volkova", "Natali", LocalDate.of(2000, 8, 31),
//                "KB333333", "566767677",
//                LocalDate.of(2022, 12, 12),
//                LocalDate.of(2030, 01, 01)),
//                new ClientAddressDto(CLIENT_ADDRESS_ID, "Belarus", "Mogilev", "Pervomayskay",
//                        "32", "01", "22-22-22"));
//clientDao.save(clientDto);
//        System.out.println(clientDto);
//
//        clientDao.delete(CLIENT_ID);
//       // verify(clientDao).delete(CLIENT_ID);
//        assertNull(clientDto.getId());
//    }

//    @Test
//    public void update() {
//        ClientDto clientDto = new ClientDto(CLIENT_ID, "username", "password", "email",Role.USER,
//                new ClientDetailsDto("1", "surname", "name",
//                        LocalDate.of(2000, 8, 31) , " ", "",
//                        LocalDate.of(2000, 8, 31),
//                        LocalDate.of(2000, 8, 31)),
//                new ClientAddressDto("1", "country", "city", "street", "houseNumber", "flatNumber", "phoneNumber"));
//
//       // clientDao.save(clientDto);
//
//
//
//      clientDao.update(clientDto);
//        assertEquals("1", company.getId());
//        assertEquals("Facebook", company.getName());
//    }

//    @Test
//    public void findById() {
//        ClientDto clientDto = new ClientDto(CLIENT_ID,
//                "nata", "hjhj", "nat@gmail.com",Role.USER, new ClientDetailsDto(
//                CLIENT_DETAILS_ID, "Volkova", "Natali", LocalDate.of(2000, 8, 31),
//                "KB333333", "566767677",
//                LocalDate.of(2022, 12, 12),
//                LocalDate.of( 2030, 01, 01)),
//                new ClientAddressDto(CLIENT_ADDRESS_ID, "Belarus",  "Mogilev", "Pervomayskay",
//                        "32", "01", "22-22-22"));
//
//        clientDao.save(clientDto);
//        System.out.println(clientDto);

      //  Optional<ClientDto> result = clientDao.findById(CLIENT_ID);
//        Optional<ClientDto> result = clientDao.findById(CLIENT_ID);
//
//        assertTrue(result.isPresent());
//        assertEquals(clientDto, result.get());
//
//        assertEquals(CLIENT_ID, result.orElseThrow().getId());
//        assertEquals("nata", result.orElseThrow().getUsername());
//        assertEquals("Volkova", result.orElseThrow().getClientDetailsDto().getSurname());
//        assertEquals("Belarus", result.orElseThrow().getClientAddressDto().getCountry());
//
//    }


//    @Test
//    public void findAll() {
//        List<ClientDto> clients = new ArrayList<>();
//        clients.add(new ClientDto("1", "nata", "12345", "nat@mail.ru", new ClientDetails(), new ClientAddress()));
//        clients.add(new ClientDto("2", "bob", "14444", "bob@mail.ru", new ClientDetails(), new ClientAddress()));
//        clients.add(new ClientDto("3", "star", "47474", "star@mail.ru", new ClientDetails(), new ClientAddress()));
//
//
//        System.out.println(clients);
//        when(clientDao.findAll()).thenReturn(clients);
//
//        List<ClientDto> result = clientDao.findAll();
//        System.out.println(result);
//
//        assertEquals(clients, result);
//




