package xn1;

import com.tencent.mobileqq.guild.feed.topic.h;
import com.tencent.mobileqq.guild.feed.topic.mvi.FeedListState;
import com.tencent.mobileqq.guild.util.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a \u0010\u0006\u001a\u00020\u0000*\u00020\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0004\u001a\u001a\u0010\t\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\b\u001a\u0012\u0010\f\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u000b\u001a\u00020\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/topic/mvi/a;", "", "Lvn1/b;", "newFeedList", "Lxn1/b;", "args", "a", "modifyFeed", "Lxn1/c;", "b", "Lxn1/d;", "argsV2", "c", "qqguild_feed_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class a {
    @NotNull
    public static final FeedListState a(@NotNull FeedListState feedListState, @NotNull List<? extends vn1.b> newFeedList, @NotNull InsertFeedArgs args) {
        Object obj;
        boolean z16;
        Intrinsics.checkNotNullParameter(feedListState, "<this>");
        Intrinsics.checkNotNullParameter(newFeedList, "newFeedList");
        Intrinsics.checkNotNullParameter(args, "args");
        if (!newFeedList.isEmpty()) {
            ArrayList arrayList = new ArrayList(feedListState.c().b());
            if (args.c() != null) {
                ArrayList arrayList2 = new ArrayList();
                for (Object obj2 : newFeedList) {
                    Iterator it = arrayList.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            obj = it.next();
                            vn1.b it5 = (vn1.b) obj;
                            Function1<vn1.b, Boolean> c16 = args.c();
                            Intrinsics.checkNotNullExpressionValue(it5, "it");
                            if (c16.invoke(it5).booleanValue()) {
                                break;
                            }
                        } else {
                            obj = null;
                            break;
                        }
                    }
                    if (obj == null) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        arrayList2.add(obj2);
                    }
                }
                newFeedList = arrayList2;
            }
            if (newFeedList.isEmpty()) {
                Logger logger = Logger.f235387a;
                Logger.b bVar = new Logger.b();
                bVar.a().add("onInsertFeed filterNewFeedList isEmpty");
                Iterator<T> it6 = bVar.a().iterator();
                while (it6.hasNext()) {
                    Logger.f235387a.d().e("FeedListStateEx", 1, (String) it6.next(), null);
                }
                return feedListState;
            }
            if (arrayList.size() >= args.getIndex()) {
                arrayList.addAll(args.getIndex(), newFeedList);
            } else {
                arrayList.addAll(newFeedList);
            }
            return FeedListState.b(feedListState, null, false, new h(arrayList), false, args.getScrollPos(), args.getNeedInsertAnimator(), 11, null);
        }
        return feedListState;
    }

    @NotNull
    public static final FeedListState b(@NotNull FeedListState feedListState, @NotNull vn1.b modifyFeed, @NotNull ModifyFeedArgs args) {
        Object obj;
        Intrinsics.checkNotNullParameter(feedListState, "<this>");
        Intrinsics.checkNotNullParameter(modifyFeed, "modifyFeed");
        Intrinsics.checkNotNullParameter(args, "args");
        ArrayList arrayList = new ArrayList(feedListState.c().b());
        Iterator it = arrayList.iterator();
        int i3 = 0;
        int i16 = 0;
        while (true) {
            if (it.hasNext()) {
                vn1.b it5 = (vn1.b) it.next();
                Function1<vn1.b, Boolean> c16 = args.c();
                Intrinsics.checkNotNullExpressionValue(it5, "it");
                if (c16.invoke(it5).booleanValue()) {
                    break;
                }
                i16++;
            } else {
                i16 = -1;
                break;
            }
        }
        if (i16 >= 0) {
            arrayList.remove(i16);
            i3 = i16;
        } else {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            String str = "onModifyFeed not find idd:" + modifyFeed.d().getFeedId();
            if (str instanceof String) {
                bVar.a().add(str);
            }
            Iterator<T> it6 = bVar.a().iterator();
            while (it6.hasNext()) {
                Logger.f235387a.d().e("FeedListStateEx", 1, (String) it6.next(), null);
            }
            if (!args.getActionWhenNotExist()) {
                return feedListState;
            }
        }
        Iterator it7 = arrayList.iterator();
        while (true) {
            if (it7.hasNext()) {
                obj = it7.next();
                vn1.b it8 = (vn1.b) obj;
                Function1<vn1.b, Boolean> b16 = args.b();
                Intrinsics.checkNotNullExpressionValue(it8, "it");
                if (b16.invoke(it8).booleanValue()) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        if (obj == null) {
            arrayList.add(i3, modifyFeed);
            return FeedListState.b(feedListState, null, false, new h(arrayList), false, 0, false, 59, null);
        }
        Logger logger2 = Logger.f235387a;
        Logger.b bVar2 = new Logger.b();
        String str2 = "onModifyFeed addPredicate return true idd:" + modifyFeed.d().getFeedId();
        if (str2 instanceof String) {
            bVar2.a().add(str2);
        }
        Iterator<T> it9 = bVar2.a().iterator();
        while (it9.hasNext()) {
            Logger.f235387a.d().e("FeedListStateEx", 1, (String) it9.next(), null);
        }
        return feedListState;
    }

    @NotNull
    public static final FeedListState c(@NotNull FeedListState feedListState, @NotNull ModifyFeedArgsV2 argsV2) {
        Intrinsics.checkNotNullParameter(feedListState, "<this>");
        Intrinsics.checkNotNullParameter(argsV2, "argsV2");
        ArrayList arrayList = new ArrayList(feedListState.c().b());
        Iterator it = arrayList.iterator();
        int i3 = 0;
        while (true) {
            if (it.hasNext()) {
                vn1.b it5 = (vn1.b) it.next();
                Function1<vn1.b, Boolean> b16 = argsV2.b();
                Intrinsics.checkNotNullExpressionValue(it5, "it");
                if (b16.invoke(it5).booleanValue()) {
                    break;
                }
                i3++;
            } else {
                i3 = -1;
                break;
            }
        }
        if (i3 < 0) {
            Logger.f235387a.d().i("FeedListStateEx", 1, "onModifyFeed not find");
            return feedListState;
        }
        vn1.b bVar = (vn1.b) arrayList.get(i3);
        Function1<vn1.b, vn1.b> a16 = argsV2.a();
        Intrinsics.checkNotNullExpressionValue(bVar, "this");
        vn1.b invoke = a16.invoke(bVar);
        arrayList.remove(i3);
        arrayList.add(i3, invoke);
        return FeedListState.b(feedListState, null, false, new h(arrayList), false, 0, false, 59, null);
    }
}
