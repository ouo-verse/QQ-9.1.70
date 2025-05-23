package tencent.im.oidb.cmd0xc76;

import com.tencent.biz.pubaccount.api.IPublicAccountBrowser;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xc76$Item extends MessageMicro<oidb_cmd0xc76$Item> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 40, 48}, new String[]{"id", "name", "icon", "value", "type", IPublicAccountBrowser.KEY_PUB_UIN}, new Object[]{0L, "", "", 0, 0, 0L}, oidb_cmd0xc76$Item.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBUInt64Field f435986id = PBField.initUInt64(0);
    public final PBStringField name = PBField.initString("");
    public final PBStringField icon = PBField.initString("");
    public final PBUInt32Field value = PBField.initUInt32(0);
    public final PBUInt32Field type = PBField.initUInt32(0);
    public final PBUInt64Field puin = PBField.initUInt64(0);
}
