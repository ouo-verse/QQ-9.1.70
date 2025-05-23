package weprotocols;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes30.dex */
public final class WEProtocolsVaslive$SeatUserList extends MessageMicro<WEProtocolsVaslive$SeatUserList> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{16, 24, 40, 50, 58}, new String[]{"seatNo", "uid", "sourceType", "userBasic", "extInfo"}, new Object[]{0, 0L, 0, null, ""}, WEProtocolsVaslive$SeatUserList.class);
    public final PBInt32Field seatNo = PBField.initInt32(0);
    public final PBUInt64Field uid = PBField.initUInt64(0);
    public final PBEnumField sourceType = PBField.initEnum(0);
    public WEProtocolsVaslive$UserBasic userBasic = new WEProtocolsVaslive$UserBasic();
    public final PBStringField extInfo = PBField.initString("");
}
