package com.soonyoong.junit;

public class RegistrationServiceImpl implements RegistrationService {
    @Override
    public User register(String name, String phone) throws Exception {
        if (name == null || name.isEmpty()) {
            throw new Exception("Name is required");
        }

        String areaCode = FindUtils.getAreaCode(phone);
        String operatorCode = FindUtils.getOperatorCode(phone);
        return new User(name, phone, areaCode, operatorCode);

    }
}
