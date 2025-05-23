package trpc.cmshow.game;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class OpenGameBox$StScene extends MessageMicro<OpenGameBox$StScene> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"scene_id", "refresh_interval", "items"}, new Object[]{0, 0L, null}, OpenGameBox$StScene.class);
    public final PBUInt32Field scene_id = PBField.initUInt32(0);
    public final PBUInt64Field refresh_interval = PBField.initUInt64(0);
    public final PBRepeatMessageField<OpenGameBox$StBoxItem> items = PBField.initRepeatMessage(OpenGameBox$StBoxItem.class);
}
