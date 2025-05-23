package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mtt.hippy.views.hippylist.ViewStickEventHelper;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleRead$TagItem extends MessageMicro<QQCircleRead$TagItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32, 40, 48}, new String[]{"name", "tagType", "joinNum", "isFollow", "isTop", ViewStickEventHelper.IS_SHOW}, new Object[]{"", 0, 0L, 0L, 0L, 0}, QQCircleRead$TagItem.class);
    public final PBStringField name = PBField.initString("");
    public final PBInt32Field tagType = PBField.initInt32(0);
    public final PBInt64Field joinNum = PBField.initInt64(0);
    public final PBInt64Field isFollow = PBField.initInt64(0);
    public final PBInt64Field isTop = PBField.initInt64(0);
    public final PBInt32Field isShow = PBField.initInt32(0);
}
