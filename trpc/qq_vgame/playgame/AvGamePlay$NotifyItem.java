package trpc.qq_vgame.playgame;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.vip.impl.VasQQSettingMeImpl;

/* loaded from: classes29.dex */
public final class AvGamePlay$NotifyItem extends MessageMicro<AvGamePlay$NotifyItem> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field appid = PBField.initUInt32(0);
    public final PBUInt64Field expire_time;
    public final PBBytesField timer_key;
    public final PBBytesField timer_userid;
    public final PBBytesField user_data;

    static {
        String[] strArr = {"appid", "timer_userid", "timer_key", VasQQSettingMeImpl.EXPIRE_TIME, QCircleScheme.AttrQQPublish.BUSINESS_USER_DATA};
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 42}, strArr, new Object[]{0, byteStringMicro, byteStringMicro, 0L, byteStringMicro}, AvGamePlay$NotifyItem.class);
    }

    public AvGamePlay$NotifyItem() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.timer_userid = PBField.initBytes(byteStringMicro);
        this.timer_key = PBField.initBytes(byteStringMicro);
        this.expire_time = PBField.initUInt64(0L);
        this.user_data = PBField.initBytes(byteStringMicro);
    }
}
