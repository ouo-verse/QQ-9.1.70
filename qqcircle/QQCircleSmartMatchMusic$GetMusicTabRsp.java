package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleSmartMatchMusic$GetMusicTabRsp extends MessageMicro<QQCircleSmartMatchMusic$GetMusicTabRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"qq_music_tab"}, new Object[]{0}, QQCircleSmartMatchMusic$GetMusicTabRsp.class);
    public final PBInt32Field qq_music_tab = PBField.initInt32(0);
}
