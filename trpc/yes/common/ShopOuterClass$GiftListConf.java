package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class ShopOuterClass$GiftListConf extends MessageMicro<ShopOuterClass$GiftListConf> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 800, 808}, new String[]{"gift_id", "tag_id", "tag_expire_time", "is_event_gift", "event_start_time", "event_end_time", "_sort", "_ctime"}, new Object[]{0, 0, 0, Boolean.FALSE, 0, 0, 0, 0}, ShopOuterClass$GiftListConf.class);
    public final PBInt32Field gift_id = PBField.initInt32(0);
    public final PBUInt32Field tag_id = PBField.initUInt32(0);
    public final PBUInt32Field tag_expire_time = PBField.initUInt32(0);
    public final PBBoolField is_event_gift = PBField.initBool(false);
    public final PBUInt32Field event_start_time = PBField.initUInt32(0);
    public final PBUInt32Field event_end_time = PBField.initUInt32(0);
    public final PBInt32Field _sort = PBField.initInt32(0);
    public final PBUInt32Field _ctime = PBField.initUInt32(0);
}
