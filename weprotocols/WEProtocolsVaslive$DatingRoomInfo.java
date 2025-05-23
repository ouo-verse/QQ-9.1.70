package weprotocols;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes30.dex */
public final class WEProtocolsVaslive$DatingRoomInfo extends MessageMicro<WEProtocolsVaslive$DatingRoomInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"gameID", "seatUsers"}, new Object[]{0, null}, WEProtocolsVaslive$DatingRoomInfo.class);
    public final PBUInt32Field gameID = PBField.initUInt32(0);
    public final PBRepeatMessageField<WEProtocolsVaslive$SeatUserList> seatUsers = PBField.initRepeatMessage(WEProtocolsVaslive$SeatUserList.class);
}
