package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class YoloBattleSmobaOuterClass$YoloSmobaBattleConfig extends MessageMicro<YoloBattleSmobaOuterClass$YoloSmobaBattleConfig> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{"create_type", "game_mode", "server_id", "camp_add_type"}, new Object[]{0, 0, 0, 0}, YoloBattleSmobaOuterClass$YoloSmobaBattleConfig.class);
    public final PBInt32Field create_type = PBField.initInt32(0);
    public final PBInt32Field game_mode = PBField.initInt32(0);
    public final PBInt32Field server_id = PBField.initInt32(0);
    public final PBInt32Field camp_add_type = PBField.initInt32(0);
}
