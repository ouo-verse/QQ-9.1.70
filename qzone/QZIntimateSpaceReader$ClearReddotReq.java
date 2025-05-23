package qzone;

import com.tencent.mobileqq.mini.out.webPlugins.MiniAppPlugin;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QZIntimateSpaceReader$ClearReddotReq extends MessageMicro<QZIntimateSpaceReader$ClearReddotReq> {
    public static final int FEEDS = 2;
    public static final int MEDAL = 3;
    public static final int NONE_PAGE = 0;
    public static final int PSV = 1;
    public static final int SHARE_STATUS = 4;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{MiniAppPlugin.ATTR_PAGE_TYPE}, new Object[]{0}, QZIntimateSpaceReader$ClearReddotReq.class);
    public final PBEnumField page_type = PBField.initEnum(0);
}
