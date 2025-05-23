package qqcircle;

import com.tencent.mobileqq.emoticon.CommonUsedSystemEmojiManagerConstants;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class Hotspots$AttachInfo extends MessageMicro<Hotspots$AttachInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{CommonUsedSystemEmojiManagerConstants.LAST_REQUEST_TIME, "lastNeedUpdateTime"}, new Object[]{0L, 0L}, Hotspots$AttachInfo.class);
    public final PBInt64Field lastRequestTime = PBField.initInt64(0);
    public final PBInt64Field lastNeedUpdateTime = PBField.initInt64(0);
}
