package tencent.im.oidb.cmd0xe6b;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import tencent.im.oidb.cmd0xd2d.oidb_cmd0xd2d_common$EduHis;

/* loaded from: classes29.dex */
public final class beancurdcube_profile_common$BeancurdcubeProfileInfo extends MessageMicro<beancurdcube_profile_common$BeancurdcubeProfileInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 160018, 160090, 160154, 160250, 160258, 192018, 192066, 216298, 218114}, new String[]{"enum_beancurdcube_profile_type", "uint32_last_modify_time", "msg_nickname", "msg_email", "msg_intro", "msg_birthday", "msg_location", "msg_homeland", "msg_company", "msg_occupation", "msg_education"}, new Object[]{0, 0, null, null, null, null, null, null, null, null, null}, beancurdcube_profile_common$BeancurdcubeProfileInfo.class);
    public final PBUInt32Field enum_beancurdcube_profile_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_last_modify_time = PBField.initUInt32(0);
    public beancurdcube_profile_common$ProfileNickname msg_nickname = new MessageMicro<beancurdcube_profile_common$ProfileNickname>() { // from class: tencent.im.oidb.cmd0xe6b.beancurdcube_profile_common$ProfileNickname
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"bytes_nickname"}, new Object[]{ByteStringMicro.EMPTY}, beancurdcube_profile_common$ProfileNickname.class);
        public final PBBytesField bytes_nickname = PBField.initBytes(ByteStringMicro.EMPTY);
    };
    public beancurdcube_profile_common$ProfileBirthday msg_birthday = new MessageMicro<beancurdcube_profile_common$ProfileBirthday>() { // from class: tencent.im.oidb.cmd0xe6b.beancurdcube_profile_common$ProfileBirthday
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"uint32_birthday"}, new Object[]{0}, beancurdcube_profile_common$ProfileBirthday.class);
        public final PBUInt32Field uint32_birthday = PBField.initUInt32(0);
    };
    public beancurdcube_profile_common$ProfileEducation msg_education = new MessageMicro<beancurdcube_profile_common$ProfileEducation>() { // from class: tencent.im.oidb.cmd0xe6b.beancurdcube_profile_common$ProfileEducation
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"msg_edu"}, new Object[]{null}, beancurdcube_profile_common$ProfileEducation.class);
        public oidb_cmd0xd2d_common$EduHis msg_edu = new MessageMicro<oidb_cmd0xd2d_common$EduHis>() { // from class: tencent.im.oidb.cmd0xd2d.oidb_cmd0xd2d_common$EduHis
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"rpt_msg_school"}, new Object[]{null}, oidb_cmd0xd2d_common$EduHis.class);
            public final PBRepeatMessageField<oidb_cmd0xd2d_common$SchoolInfo> rpt_msg_school = PBField.initRepeatMessage(oidb_cmd0xd2d_common$SchoolInfo.class);
        };
    };
    public beancurdcube_profile_common$ProfileLocation msg_location = new MessageMicro<beancurdcube_profile_common$ProfileLocation>() { // from class: tencent.im.oidb.cmd0xe6b.beancurdcube_profile_common$ProfileLocation
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{"uint32_nation", "uint32_province", "uint32_city", "uint32_district"}, new Object[]{0, 0, 0, 0}, beancurdcube_profile_common$ProfileLocation.class);
        public final PBUInt32Field uint32_nation = PBField.initUInt32(0);
        public final PBUInt32Field uint32_province = PBField.initUInt32(0);
        public final PBUInt32Field uint32_city = PBField.initUInt32(0);
        public final PBUInt32Field uint32_district = PBField.initUInt32(0);
    };
    public beancurdcube_profile_common$ProfileHomeLand msg_homeland = new MessageMicro<beancurdcube_profile_common$ProfileHomeLand>() { // from class: tencent.im.oidb.cmd0xe6b.beancurdcube_profile_common$ProfileHomeLand
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{"uint32_nation", "uint32_province", "uint32_city", "uint32_district"}, new Object[]{0, 0, 0, 0}, beancurdcube_profile_common$ProfileHomeLand.class);
        public final PBUInt32Field uint32_nation = PBField.initUInt32(0);
        public final PBUInt32Field uint32_province = PBField.initUInt32(0);
        public final PBUInt32Field uint32_city = PBField.initUInt32(0);
        public final PBUInt32Field uint32_district = PBField.initUInt32(0);
    };
    public beancurdcube_profile_common$ProfileCompany msg_company = new MessageMicro<beancurdcube_profile_common$ProfileCompany>() { // from class: tencent.im.oidb.cmd0xe6b.beancurdcube_profile_common$ProfileCompany
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"company_name"}, new Object[]{ByteStringMicro.EMPTY}, beancurdcube_profile_common$ProfileCompany.class);
        public final PBBytesField company_name = PBField.initBytes(ByteStringMicro.EMPTY);
    };
    public beancurdcube_profile_common$ProfileOccupation msg_occupation = new MessageMicro<beancurdcube_profile_common$ProfileOccupation>() { // from class: tencent.im.oidb.cmd0xe6b.beancurdcube_profile_common$ProfileOccupation
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"uint32_occupation_id"}, new Object[]{0}, beancurdcube_profile_common$ProfileOccupation.class);
        public final PBUInt32Field uint32_occupation_id = PBField.initUInt32(0);
    };
    public beancurdcube_profile_common$ProfileEmail msg_email = new MessageMicro<beancurdcube_profile_common$ProfileEmail>() { // from class: tencent.im.oidb.cmd0xe6b.beancurdcube_profile_common$ProfileEmail
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"bytes_email"}, new Object[]{ByteStringMicro.EMPTY}, beancurdcube_profile_common$ProfileEmail.class);
        public final PBBytesField bytes_email = PBField.initBytes(ByteStringMicro.EMPTY);
    };
    public beancurdcube_profile_common$ProfileIntro msg_intro = new MessageMicro<beancurdcube_profile_common$ProfileIntro>() { // from class: tencent.im.oidb.cmd0xe6b.beancurdcube_profile_common$ProfileIntro
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"bytes_intro"}, new Object[]{ByteStringMicro.EMPTY}, beancurdcube_profile_common$ProfileIntro.class);
        public final PBBytesField bytes_intro = PBField.initBytes(ByteStringMicro.EMPTY);
    };
}
