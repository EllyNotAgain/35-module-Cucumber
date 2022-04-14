Feature: login to the site
  Scenario: login with invalid data
    Given url of dns-shop 'https://www.dns-shop.ru/'
    When website is open click login button
    Then click login with password
    Then enter email 'test' and password 'test'
    Then click submit button
    Then assert message 'Введите корректный логин (e-mail или телефон)' is visible

  Scenario: login with valid data
    Given url of dns-shop 'https://www.dns-shop.ru/'
    When website is open click login button
    Then click login with password
    Then enter email 'qa-sf@mail.ru' and password 'DNSP@ssw0rd'
    Then click submit button
    Then click profile link
    Then assert login email 'qa-sf@mail.ru' = profile email

