package weprotocols;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes30.dex */
public final class WEProtocolsVaslive$UserBasic extends MessageMicro<WEProtocolsVaslive$UserBasic> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32}, new String[]{"uid", "nick", "logo", "gender"}, new Object[]{0L, "", null, 0}, WEProtocolsVaslive$UserBasic.class);
    public final PBUInt64Field uid = PBField.initUInt64(0);
    public final PBStringField nick = PBField.initString("");
    public WEProtocolsVaslive$PictureURL logo = new WEProtocolsVaslive$PictureURL();
    public final PBUInt32Field gender = PBField.initUInt32(0);
}
