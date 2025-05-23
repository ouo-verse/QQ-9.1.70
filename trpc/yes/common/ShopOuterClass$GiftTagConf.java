package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class ShopOuterClass$GiftTagConf extends MessageMicro<ShopOuterClass$GiftTagConf> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 42}, new String[]{"tag_id", "tag_name", "tag_icon"}, new Object[]{0, "", ""}, ShopOuterClass$GiftTagConf.class);
    public final PBUInt32Field tag_id = PBField.initUInt32(0);
    public final PBStringField tag_name = PBField.initString("");
    public final PBStringField tag_icon = PBField.initString("");
}
