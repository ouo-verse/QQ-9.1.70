package tencent.im.nearfield_group;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class nearfield_group$GroupProfile extends MessageMicro<nearfield_group$GroupProfile> {
    public static final int BYTES_DISTANCE_FIELD_NUMBER = 5;
    public static final int BYTES_GROUP_NAME_FIELD_NUMBER = 2;
    public static final int BYTES_OWNER_NICK_FIELD_NUMBER = 4;
    public static final int UINT64_GROUP_CODE_FIELD_NUMBER = 1;
    public static final int UINT64_OWNER_UIN_FIELD_NUMBER = 3;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_distance;
    public final PBBytesField bytes_group_name;
    public final PBBytesField bytes_owner_nick;
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0);
    public final PBUInt64Field uint64_owner_uin;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34, 42}, new String[]{"uint64_group_code", "bytes_group_name", "uint64_owner_uin", "bytes_owner_nick", "bytes_distance"}, new Object[]{0L, byteStringMicro, 0L, byteStringMicro, byteStringMicro}, nearfield_group$GroupProfile.class);
    }

    public nearfield_group$GroupProfile() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_group_name = PBField.initBytes(byteStringMicro);
        this.uint64_owner_uin = PBField.initUInt64(0L);
        this.bytes_owner_nick = PBField.initBytes(byteStringMicro);
        this.bytes_distance = PBField.initBytes(byteStringMicro);
    }
}
