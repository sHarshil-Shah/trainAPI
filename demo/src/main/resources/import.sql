--with customer_json (doc) as (
--   values
--    ('[
--      {
--        "id": 3,
--        "name": "Jerry Green",
--        "aminities": "Imported from facebook.",
--        "distance": "Imported from facebook.",
--        "description": "Imported from facebook.",
--        "frequency": "Imported from facebook.",
--        "grade_crossing": true,
--        "speed": "Imported from facebook.",
--        "sharing_track": false
--      },
--      {
--        "id": 4,
--                "name": "Jerry Green2",
--                "aminities": "Imported from facebook.",
--                "distance": "Imported from facebook.",
--                "description": "Imported from facebook.",
--                "frequency": "Imported from facebook.",
--                "grade_crossing": true,
--                "speed": "Imported from facebook.",
--                "sharing_track": false
--      }
--    ]'::json)
--)
--insert into Train( id, name, aminities, distance, description, frequency, grade_crossing, speed, sharing_track)
--select p.*
--from customer_json l
--  cross join lateral json_populate_recordset(null::train, doc) as p
--on conflict (id) do update
--  set name = excluded.name,
--      comment = excluded.comment;

INSERT INTO public.train(id,name,description,distance_between_stop,max_speed,sharing_tracks,grade_crossing,train_frequency,amenities) VALUES (1,'Light rail','Light rail, which might be also known as trolley and streetcars, mean trains that function as local transit in an urban_core and can operate on the street_level. Compared to rapid transit, light rail costs less, is more pedestrian friendly, but has less passenger capacity. The major advantage with light rail is that it can operate like rapid transit or like local buses, depending on the available infrastructure','a few blocks to 1 or 2 miles','55_65 mph','true','false','3_30 minutes','n/a');
INSERT INTO public.train(id,name,description,distance_between_stop,max_speed,sharing_tracks,grade_crossing,train_frequency,amenities) VALUES (2,'Rapid transit','Rapid transit, which is also known as metro, subway, and heavy rail, mean trains that generally serve the urban_core, have large passenger capacity, and operate totally separate from road traffic. In order to run separately from road traffic in the city_core, rapid transit trains would run either above or underground.','1/2 mile to 2 or 3 miles','65_70 mph','false','false','3_20 minutes','Large space for standees');
INSERT INTO public.train(id,name,description,distance_between_stop,max_speed,sharing_tracks,grade_crossing,train_frequency,amenities) VALUES (3,'Commuter rail','Commuter trains generally mean trains connecting suburban areas with the central city and primarily serves riders to and from work. Commuter trains typically run on weekdays, during rush hours, and only in the peak directions.','1 to 2 miles','79 mph','true','true','15 minutes to hourly (some operate only during weekday peak hours)','Restroom');
INSERT INTO public.train(id,name,description,distance_between_stop,max_speed,sharing_tracks,grade_crossing,train_frequency,amenities) VALUES (4,'Inter_city rail','Inter_city trains generally mean trains traveling long distances connecting metropolitan areas. Although the distances covered by some of these trains are comparable to airlines, inter_city trains generally operate at highway speed. Long distance inter_city trains may provide amenities not found on most other forms of transportation, including sleeper_cars and cafe/dining cars.','2 to 10 miles','79 mph','true','true','Hourly to once a day, or even three trips a week.','Restroom, business class, sleeper (longer distance), cafe car, dining car');
INSERT INTO public.train(id,name,description,distance_between_stop,max_speed,sharing_tracks,grade_crossing,train_frequency,amenities) VALUES (5,'High speed rail','High speed trains are generally defined as trains that can operate 125mph or faster. High speed trains generally connect large metropolitan areas (with very few stops in between) and are meant to be competitive with airlines in terms of overall travel time.','at least 10 miles','at least 90 mph','false','false','15 minutes to hourly','Restroom, business class, cafe car');
INSERT INTO public.train(id,name,description,distance_between_stop,max_speed,sharing_tracks,grade_crossing,train_frequency,amenities) VALUES (6,'Eurostar e320','Eurostar e320 was created as a single and unified corporate entity owned by SNCF, SNCB and LCR in September 2010. In December, a £700m (approximately $1,076bn) investment to add ten new e320 trains to its fleet and carry out a complete upgrade of its existing 28 trains. It is capable of carrying more than 900 passengers as a result of the 20% capacity boost given to it, compared to the existing 28 Eurostar trains which carry 750 passengers. The entire propulsion system and technical modules are distributed under the floor over the entire length of the train, providing more space for passengers. The train’s roof is equipped with eight pantographs for dealing with Europe’s different power systems and contact line types.','at least 200 miles','200 mph','false','false','12 hours','Restroom, business class, cafe car, Wi_Fi, Onboard flat_screens. Reclining seats, flexible reading lamp, a sliding dining table and more luggage areas. Four spaces are provided for wheelchair passengers.');
INSERT INTO public.train(id,name,description,distance_between_stop,max_speed,sharing_tracks,grade_crossing,train_frequency,amenities) VALUES (7,'L0 Series Maglev','This Japanese train, which is currently being developed and tested by the Central Japan Railway Company (JR Central), holds the land speed record for rail vehicles, clocking in at 374 mph. The L0 Series technology, called maglev (magnetic levitation train), actually makes the train levitate at speeds exceeding around 93 mph. The technology is currently being employed worldwide (see see number four), and there are talks of it being used for a train between Washington, D.C. and Baltimore.','at least 100 miles','374 mph','false','false','6 hours','Restroom, business class, cafe car, Wi_Fi, Onboard flat_screens. Reclining seats, flexible reading lamp.');
INSERT INTO public.train(id,name,description,distance_between_stop,max_speed,sharing_tracks,grade_crossing,train_frequency,amenities) VALUES (8,'TGV POS','France has had high_speed rail travel dialed in for many years. And in 2007, the TGV POS set the world speed record for rail vehicles at an impressive 357 mph, before being surpassed by Japan''s L0 Series in 2015. The train is operated by French rail company SNCF for use on the LGV Est route, which runs between Paris, eastern France, and southern Germany. While in regular service, the train reaches a top speed of 200 mph. It''s not 357 mph, but it''s still shockingly fast.','at least 150 miles','357 mph','false','false','7 hours','Wi_Fi, Restroom, Onboard flat_screens. Reclining seats, flexible reading lamp, a sliding dining table.');
INSERT INTO public.train(id,name,description,distance_between_stop,max_speed,sharing_tracks,grade_crossing,train_frequency,amenities) VALUES (9,'CRH380A Hexie','While China''s CRH380A Hexie (also called Harmony) can cruise at a maximum speed of 236 mph for commercial operations, it reached a whopping 302 mph during testing. And what''s even more impressive is that the high_speed electric train is just one of four Chinese train series developed to operate on the newly constructed high_speed main lines. The CRH380A may be the fastest, but the other three are nothing to scoff at — check out the CRH380B, CRH380C, and CRH380D.','at least 100 miles','302 mph','false','false','5 hours','Restroom, business class, Wi_Fi, Onboard flat_screens. Reclining seats, flexible reading lamp, dining table');
INSERT INTO public.train(id,name,description,distance_between_stop,max_speed,sharing_tracks,grade_crossing,train_frequency,amenities) VALUES (10,'Shanghai Maglev','Similar to Japan''s L0 Series, the Shanghai maglev (also called the Shanghai Transrapid) is a magnetic levitation train that operates out of Shanghai, China. And while it lands solidly at number four on this list, thanks to a top speed of 268 mph, it''s actually the oldest commercial maglev train still in operation. If you fly into Shanghai Pudong International Airport, riding this train is easy. You can hop off in central Shanghai or take it all the way to the outskirts of central Pudong, where the line ends.','at least 100 miles','268 mph','false','false','4 hours','Wi_Fi, Restroom, business class, cafe car, Wi_Fi, Onboard flat_screens. Flexible reading lamp, a sliding dining table and more luggage areas.');

INSERT INTO public.roles (id, name)VALUES (0, 'ROLE_USER');
INSERT INTO public.roles (id, name)VALUES (1, 'ROLE_MODERATOR');
INSERT INTO public.roles (id, name)VALUES (2, 'ROLE_ADMIN');