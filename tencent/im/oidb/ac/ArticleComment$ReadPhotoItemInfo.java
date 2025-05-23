package tencent.im.oidb.ac;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class ArticleComment$ReadPhotoItemInfo extends MessageMicro<ArticleComment$ReadPhotoItemInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"index", "item_remain_time", "item_type"}, new Object[]{0, 0, 0}, ArticleComment$ReadPhotoItemInfo.class);
    public final PBUInt32Field index = PBField.initUInt32(0);
    public final PBUInt32Field item_remain_time = PBField.initUInt32(0);
    public final PBUInt32Field item_type = PBField.initUInt32(0);
}
